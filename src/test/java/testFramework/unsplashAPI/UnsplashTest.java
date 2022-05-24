package testFramework.unsplashAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import testFramework.credentials.UnsplashCredentials;
import testFramework.unsplashAPI.model.Response;
import testFramework.unsplashAPI.model.Token;

import java.io.IOException;
import java.net.URISyntaxException;

public class UnsplashTest {
    private String IDCollection;

    @BeforeSuite
    void getToken() throws URISyntaxException, IOException, InterruptedException {
        Response response = Client.execute(RequestRepo.buildAuthRequest());
        Token token = Client.parseJSONToObject(response, Token.class);
        UnsplashCredentials.AUTH_TOKEN.setCode(token.getAccess_token());
    }

    @Test
    void createCollection() throws URISyntaxException, IOException, InterruptedException {
        String newCollectionTitle = "Test title";
        Response response = Client.execute(RequestRepo.buildCreateCollectionRequest(newCollectionTitle, "test esc"));
        IDCollection = new JSONObject(response.getBody()).getString("id");

        response = Client.execute(RequestRepo.buildGetCollectionRequest(IDCollection));
        String setTitle = new JSONObject(response.getBody()).getString("title");

        Assert.assertEquals(newCollectionTitle, setTitle, "Title [" + setTitle + "] does not match to expected: " + newCollectionTitle);
    }

    @Test(dependsOnMethods = "createCollection")
    void updateCollection() throws URISyntaxException, IOException, InterruptedException {
        String newTitle = "New title";
        Client.execute(RequestRepo.buildUpdateCollectionRequest(IDCollection, newTitle));

        Response response = Client.execute(RequestRepo.buildGetCollectionRequest(IDCollection));
        String setTitle = new JSONObject(response.getBody()).getString("title");

        Assert.assertEquals(newTitle, setTitle, "Title did not change");
    }

    @Test(dependsOnMethods = "updateCollection")
    void deleteCollection() throws URISyntaxException, IOException, InterruptedException {
        Response response = Client.execute(RequestRepo.buildDeleteCollectionRequest(IDCollection));

        Assert.assertEquals(response.getStatusCode(), 204, "Collection with id { " + IDCollection + " } was not deleted");
    }

    @Test
    void updateUserDescription() throws URISyntaxException, IOException, InterruptedException {
        String newUserBio = "New - Nothing special. Just taken photos by chance";

        Client.execute(RequestRepo.buildUpdateAuthUserRequest(newUserBio));

        Response updatedUserResponse = Client.execute(RequestRepo.buildGetAuthUserRequest());

        Assert.assertEquals(
                new JSONObject(updatedUserResponse.getBody()).getString("bio"),
                newUserBio,
                "User's bio was not updated"
        );
    }

    @Test
    void likePhoto() throws URISyntaxException, IOException, InterruptedException {
        Response response = Client.execute(RequestRepo.buildGetRandomPhotoRequest());
        String IDPhoto = new JSONObject(response.getBody()).getString("id");

        Client.execute(RequestRepo.buildLikePhotoRequest(IDPhoto));
        Response userResponse = Client.execute(RequestRepo.buildGetAuthUserRequest());

        String username = new JSONObject(userResponse.getBody()).getString("username");

        Response likedPhotos = Client.execute(RequestRepo.buildGetUserLikesRequest(username));

        Assert.assertEquals(
                new JSONArray(likedPhotos.getBody()).getJSONObject(0).getString("id"),
                IDPhoto,
                "Photo was not liked"
        );
    }
}
