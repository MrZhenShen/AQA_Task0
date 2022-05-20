package tasks.task_17;

import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;
import tasks.task_17.model.CreateTrelloBoardResponse;
import tasks.task_17.model.Request;
import tasks.task_17.model.Response;

import java.io.IOException;
import java.net.URISyntaxException;

public class TrelloTest {
    private String boardId;

    @Test
    void createBoard() throws URISyntaxException, IOException, InterruptedException {
        Response response = assertResponse(RequestRepo.buildCreateBoardRequest("Test"));
        CreateTrelloBoardResponse board = parseJSONToObject(response, CreateTrelloBoardResponse.class);
        boardId = board.getId();
    }


    @Test(dependsOnMethods = "createBoard")
    void getBoard() throws URISyntaxException, IOException, InterruptedException {
        assertResponse(RequestRepo.buildGetBoardRequest(boardId));
    }

    @Test(dependsOnMethods = "getBoard")
    void updateBoard() throws URISyntaxException, IOException, InterruptedException {
        assertResponse(RequestRepo.buildUpdateBoardRequest(boardId, "NewTest"));
    }

    @Test(dependsOnMethods = "updateBoard")
    void deleteBoard() throws URISyntaxException, IOException, InterruptedException {
        assertResponse(RequestRepo.buildDeleteBoardRequest(boardId));
    }

    private Response assertResponse(Request request) throws URISyntaxException, IOException, InterruptedException {
        Response response = Client.execute(request);
        Assert.assertEquals(response.getStatusCode(), 200, "invalid Status code");
        return response;
    }

    private <T extends Response> T parseJSONToObject(Response response, Class<T> responseClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        T parsedResponse = null;
        try {
            parsedResponse = objectMapper.readValue(response.getBody(), responseClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parsedResponse;
    }
}
