package tasks.task_16;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;

public class TrelloCRUDSimpleTest {
    private static final String CREATE_BOARD_URL = "https://api.trello.com/1/boards/?name=%s&key=%s&token=%s";
    private static final String GET_BOARD = "https://api.trello.com/1/boards/%s?key=%s&token=%s";
    private static final String UPDATE_BOARD_NAME = "https://api.trello.com/1/boards/%s?key=%s&token=%s&name=%s";
    private static final String DELETE_BOARD = "https://api.trello.com/1/boards/%s?key=%s&token=%s";

    private static final String KEY = "8d55b54ac504852ad63f35f3223e88e5";
    private static final String TOKEN = "b140d591545a706b99f4b8b840d7b955d51dace5140c738f778c247ba5f568b4";
    private static final String NEW_BOARD_NAME = "Test";
    private String boardId;

    @BeforeTest
    public void prepare() {
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void createBoard() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(CREATE_BOARD_URL, NEW_BOARD_NAME, KEY, TOKEN)))
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
                .uri(URI.create(String.format(GET_BOARD, boardId, KEY, TOKEN)))
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
                .uri(URI.create(String.format(UPDATE_BOARD_NAME, boardId, KEY, TOKEN, "NewTest")))
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
                .uri(URI.create(String.format(DELETE_BOARD, boardId, KEY, TOKEN)))
                .DELETE()
                .build();

        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        Assert.assertEquals(response.statusCode(), 200, "Invalid status code");
    }
}
