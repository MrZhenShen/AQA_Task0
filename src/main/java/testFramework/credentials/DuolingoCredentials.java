package testFramework.credentials;

public enum DuolingoCredentials {
    LOGIN(""),
    PASSWORD("");

    public final String data;

    DuolingoCredentials(String data) {
        this.data = data;
    }
}
