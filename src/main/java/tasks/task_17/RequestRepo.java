package tasks.task_17;

import tasks.task_17.model.Request;
import tasks.task_17.model.RequestMethod;

import java.util.HashMap;
import java.util.Map;

import static credentials.TrelloCredentials.KEY;
import static credentials.TrelloCredentials.TOKEN;
import static tasks.task_17.TrelloAPI.*;

public class RequestRepo {

    public static Request buildCreateBoardRequest(String boardName) {
        Request request = new Request();

        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        request.setUrl(String.format(URL_CREATE_BOARD.url, boardName, KEY.code, TOKEN.code));
        request.setBody("");
        request.setHeaders(headers);
        request.setMethod(RequestMethod.POST);
        return request;
    }

    public static Request buildGetBoardRequest(String boardId) {
        Request request = new Request();

        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        request.setUrl(String.format(URL_GET_BOARD.url, boardId, KEY.code, TOKEN.code));
        request.setBody("");
        request.setHeaders(headers);
        request.setMethod(RequestMethod.GET);
        return request;
    }

    public static Request buildUpdateBoardRequest(String boardId, String newName) {
        Request request = new Request();

        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        request.setUrl(String.format(URL_UPDATE_BOARD_NAME.url, boardId, KEY.code, TOKEN.code, newName));
        request.setBody("");
        request.setHeaders(headers);
        request.setMethod(RequestMethod.PUT);
        return request;
    }

    public static Request buildDeleteBoardRequest(String boardId) {
        Request request = new Request();

        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        request.setUrl(String.format(URL_DELETE_BOARD.url, boardId, KEY.code, TOKEN.code));
        request.setBody("");
        request.setHeaders(headers);
        request.setMethod(RequestMethod.DELETE);
        return request;
    }
}
