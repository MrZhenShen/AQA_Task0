package testFramework.unsplashAPI.model;

import static testFramework.unsplashAPI.model.RequestMethod.*;

public enum UnsplashAPI {
    AUTH("https://unsplash.com/oauth/token?client_id=%s&client_secret=%s&redirect_uri=%s&grant_type=%s&code=%s", POST),
    CREATE_COLLECTION("https://api.unsplash.com/collections?title=%s&description=%s", POST),
    GET_COLLECTION("https://api.unsplash.com/collections/%s", GET),
    UPDATE_COLLECTION("https://api.unsplash.com/collections/%s?title=%s", PUT),
    DELETE_COLLECTION("https://api.unsplash.com/collections/%s", DELETE),
    GET_AUTH_USER("https://api.unsplash.com/me", GET),
    UPDATE_AUTH_USER("https://api.unsplash.com/me?bio=%s", PUT),
    LIKE_PHOTO("https://api.unsplash.com/photos/%s/like", POST),
    GET_RANDOM_PHOTO("https://api.unsplash.com/photos/random", GET),
    GET_AUTH_USER_LIKES("https://api.unsplash.com/users/%s/likes", GET);

    public final String url;
    public final RequestMethod method;

    UnsplashAPI(String url, RequestMethod method) {
        this.url = url;
        this.method = method;
    }
}
