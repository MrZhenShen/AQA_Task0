package credentials;

public enum TrelloCredentials {
    KEY(""),
    TOKEN("");
    public final String code;

    TrelloCredentials(String code) {
        this.code = code;
    }
}
