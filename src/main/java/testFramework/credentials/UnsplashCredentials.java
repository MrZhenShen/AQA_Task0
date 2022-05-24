package testFramework.credentials;

public enum UnsplashCredentials {
    ACCESS_KEY(""),
    SECRET_KEY(""),

    AUTH_CODE(""),
    AUTH_TOKEN("");

    public String code;

    UnsplashCredentials(String code) {
        this.code = code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
