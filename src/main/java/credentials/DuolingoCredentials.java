package credentials;

public enum DuolingoCredentials {
    LOGIN("zhebog@gmail.com"),
    PASSWORD("qwerty1234");

    public final String data;

    DuolingoCredentials(String data) {
        this.data = data;
    }
}
