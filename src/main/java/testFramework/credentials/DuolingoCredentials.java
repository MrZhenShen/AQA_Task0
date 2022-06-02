package testFramework.credentials;

public enum DuolingoCredentials {
    LOGIN(""),
    PASSWORD("");

    public String data;

    DuolingoCredentials(String data) {
        this.data = data;
    }

    public void setCode(String data) {
        this.data = data;
    }
}
