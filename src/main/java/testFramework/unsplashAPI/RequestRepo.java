package testFramework.unsplashAPI;

import testFramework.unsplashAPI.model.Request;
import testFramework.unsplashAPI.model.UnsplashAPI;

import java.util.HashMap;
import java.util.Map;

import static testFramework.unsplashAPI.model.UnsplashAPI.*;
import static testFramework.credentials.UnsplashCredentials.*;

public class RequestRepo {

    public static Request buildAuthRequest() {
        UnsplashAPI api = AUTH;
        Request request = new Request();

        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        request.setUrl(String.format(api.url, ACCESS_KEY.code, SECRET_KEY.code, "urn:ietf:wg:oauth:2.0:oob", "authorization_code", AUTH_CODE.code));
        request.setBody("");
        request.setHeaders(headers);
        request.setMethod(api.method);
        return request;
    }

    public static Request buildCreateCollectionRequest(String title, String description) {
        UnsplashAPI api = CREATE_COLLECTION;
        Request request = new Request();

        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        headers.put("Authorization", "Bearer " + AUTH_TOKEN.code);
        request.setUrl(String.format(api.url, title, description).replace(" ", "%20"));
        request.setBody("");
        request.setHeaders(headers);
        request.setMethod(api.method);
        return request;
    }

    public static Request buildGetCollectionRequest(String collectionId) {
        UnsplashAPI api = GET_COLLECTION;
        Request request = new Request();

        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        headers.put("Authorization", "Bearer " + AUTH_TOKEN.code);
        request.setUrl(String.format(api.url, collectionId));
        request.setBody("");
        request.setHeaders(headers);
        request.setMethod(api.method);
        return request;
    }

    public static Request buildUpdateCollectionRequest(String collectionId, String newTitle) {
        UnsplashAPI api = UPDATE_COLLECTION;
        Request request = new Request();

        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        headers.put("Authorization", "Bearer " + AUTH_TOKEN.code);
        request.setUrl(String.format(api.url, collectionId, newTitle).replace(" ", "%20"));
        request.setBody("");
        request.setHeaders(headers);
        request.setMethod(api.method);
        return request;
    }

    public static Request buildDeleteCollectionRequest(String collectionId) {
        UnsplashAPI api = DELETE_COLLECTION;
        Request request = new Request();

        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        headers.put("Authorization", "Bearer " + AUTH_TOKEN.code);
        request.setUrl(String.format(api.url, collectionId));
        request.setBody("");
        request.setHeaders(headers);
        request.setMethod(api.method);
        return request;
    }

    public static Request buildGetAuthUserRequest() {
        UnsplashAPI api = GET_AUTH_USER;
        Request request = new Request();

        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        headers.put("Authorization", "Bearer " + AUTH_TOKEN.code);
        request.setUrl(String.format(api.url));
        request.setBody("");
        request.setHeaders(headers);
        request.setMethod(api.method);
        return request;
    }

    public static Request buildUpdateAuthUserRequest(String bio) {
        UnsplashAPI api = UPDATE_AUTH_USER;
        Request request = new Request();

        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        headers.put("Authorization", "Bearer " + AUTH_TOKEN.code);
        request.setUrl(String.format(api.url, bio).replace(" ", "%20"));
        request.setBody("");
        request.setHeaders(headers);
        request.setMethod(api.method);
        return request;
    }


    public static Request buildGetRandomPhotoRequest() {
        UnsplashAPI api = GET_RANDOM_PHOTO;
        Request request = new Request();

        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        headers.put("Authorization", "Bearer " + AUTH_TOKEN.code);
        request.setUrl(String.format(api.url));
        request.setBody("");
        request.setHeaders(headers);
        request.setMethod(api.method);
        return request;
    }

    public static Request buildLikePhotoRequest(String id) {
        UnsplashAPI api = LIKE_PHOTO;
        Request request = new Request();

        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        headers.put("Authorization", "Bearer " + AUTH_TOKEN.code);
        request.setUrl(String.format(api.url, id));
        request.setBody("");
        request.setHeaders(headers);
        request.setMethod(api.method);
        return request;
    }

    public static Request buildGetUserLikesRequest(String username) {
        UnsplashAPI api = GET_AUTH_USER_LIKES;
        Request request = new Request();

        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        headers.put("Authorization", "Bearer " + AUTH_TOKEN.code);
        request.setUrl(String.format(api.url, username));
        request.setBody("");
        request.setHeaders(headers);
        request.setMethod(api.method);
        return request;
    }
}
