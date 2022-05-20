package tasks.task_16;

import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static tasks.task_17.TrelloAPI.*;
import static credentials.TrelloCredentials.*;

public class TrelloCRUDTest {
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
                .post(String.format(URL_CREATE_BOARD.url, "Test", KEY.code, TOKEN.code));

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
                .get(String.format(URL_GET_BOARD.url, boardId, KEY.code, TOKEN.code))
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test(dependsOnMethods = "getBoard")
    void updateBoard() {
        given().when()
                .contentType("application/json")
                .log().all()
                .put(String.format(URL_UPDATE_BOARD_NAME.url, boardId, KEY.code, TOKEN.code, "NewTest"))
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test(dependsOnMethods = "updateBoard")
    void deleteBoard() {
        given().when()
                .contentType("application/json")
                .log().all()
                .delete(String.format(URL_DELETE_BOARD.url, boardId, KEY.code, TOKEN.code))
                .then()
                .assertThat()
                .statusCode(200);
    }
}
