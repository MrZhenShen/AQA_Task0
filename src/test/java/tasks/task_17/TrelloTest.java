package tasks.task_17;

import org.testng.Assert;
import org.testng.annotations.Test;
import tasks.task_17.Client;
import tasks.task_17.Request;
import tasks.task_17.RequestRepo;
import tasks.task_17.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.UUID;

public class TrelloTest {

    @Test
    void createBoard() throws URISyntaxException, IOException, InterruptedException {
        Request createBoardRequest = RequestRepo.buildCreateBoardRequest(UUID.randomUUID().toString());
        Response response = Client.execute(createBoardRequest);
        Assert.assertEquals(response.statusCode, 200, "invalid Status code");
    }

}
