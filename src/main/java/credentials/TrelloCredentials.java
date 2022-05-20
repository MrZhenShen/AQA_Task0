package credentials;

public enum TrelloCredentials {
    KEY("8d55b54ac504852ad63f35f3223e88e5"),
    TOKEN("b140d591545a706b99f4b8b840d7b955d51dace5140c738f778c247ba5f568b4");
    public final String code;

    TrelloCredentials(String code) {
        this.code = code;
    }
}
