package tasks.task_17;

import java.util.HashMap;
import java.util.Map;

public class RequestRepo {

    static String key = "06aacd672653757cb826c81e4605ab02";
    static String token = "53b31836ef880c26c79d755b48c2298c3fd2c0a94094adc266f5411e97423a1e";

    public static Request buildCreateBoardRequest(String boardName) {
        Request request = new Request();

        request.setUrl("https://api.trello.com/1/boards/?name="
                + boardName + "&key=" +
                key + "&token="
                + token +
                "");

        request.setBody("{\"idOrganization\":\"60fefe65beb2b76caa04761c\"}");

        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        request.setHeaders(headers);
        request.setMethod(RequestMethod.POST);
        return request;
    }


}
