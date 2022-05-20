package tasks.task_16;

import credentials.TrelloCredentials;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tasks.task_17.TrelloAPI;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static credentials.TrelloCredentials.KEY;
import static credentials.TrelloCredentials.TOKEN;
import static tasks.task_17.TrelloAPI.*;
import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;

public class TrelloCRUDSimpleTest {
    private String boardId;

    @BeforeTest
    public void prepare() {
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void createBoard() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(URL_CREATE_BOARD.url, "Test", KEY.code, TOKEN.code)))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        Assert.assertEquals(response.statusCode(), 200, "Invalid status code");
        boardId = new JSONObject(response.body()).getString("id");
    }

    @Test(dependsOnMethods = "createBoard")
    void getBoard() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(URL_GET_BOARD.url, boardId, KEY.code, TOKEN.code)))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        Assert.assertEquals(response.statusCode(), 200, "Invalid status code");
        System.out.println(response.body());
    }

    @Test(dependsOnMethods = "getBoard")
    void updateBoard() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(URL_UPDATE_BOARD_NAME.url, boardId, KEY.code, TOKEN.code, "NewTest")))
                .PUT(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        Assert.assertEquals(response.statusCode(), 200, "Invalid status code");
    }

    @Test(dependsOnMethods = "updateBoard")
    void deleteBoard() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(URL_DELETE_BOARD.url, boardId, KEY.code, TOKEN.code)))
                .DELETE()
                .build();

        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        Assert.assertEquals(response.statusCode(), 200, "Invalid status code");
    }
}
