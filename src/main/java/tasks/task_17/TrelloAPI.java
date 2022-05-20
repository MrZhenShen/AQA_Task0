package tasks.task_17;

public enum TrelloAPI {
    URL_CREATE_BOARD("https://api.trello.com/1/boards/?name=%s&key=%s&token=%s"),
    URL_GET_BOARD("https://api.trello.com/1/boards/%s?key=%s&token=%s"),
    URL_UPDATE_BOARD_NAME("https://api.trello.com/1/boards/%s?key=%s&token=%s&name=%s"),
    URL_DELETE_BOARD("https://api.trello.com/1/boards/%s?key=%s&token=%s");

    public final String url;

    TrelloAPI(String url) {
        this.url = url;
    }
}
