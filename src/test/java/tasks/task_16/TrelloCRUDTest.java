package tasks.task_16;

import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TrelloCRUDTest {
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
    void createBoard() {
        Response response = given()
                .when()
                .contentType("application/json")
                .log().all()
                .post(String.format(CREATE_BOARD_URL, NEW_BOARD_NAME, KEY, TOKEN));

        response.then()
                .assertThat()
                .statusCode(200);
        boardId = response.getBody().jsonPath().get("id");
    }

    @Test(dependsOnMethods = "createBoard")
    void getBoard() {
        given().when()
                .contentType("application/json")
                .log().all()
                .get(String.format(GET_BOARD, boardId, KEY, TOKEN))
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test(dependsOnMethods = "getBoard")
    void updateBoard() {
        given().when()
                .contentType("application/json")
                .log().all()
                .put(String.format(UPDATE_BOARD_NAME, boardId, KEY, TOKEN, "NewTest"))
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test(dependsOnMethods = "updateBoard")
    void deleteBoard() {
        given().when()
                .contentType("application/json")
                .log().all()
                .delete(String.format(DELETE_BOARD, boardId, KEY, TOKEN))
                .then()
                .assertThat()
                .statusCode(200);
    }
}
