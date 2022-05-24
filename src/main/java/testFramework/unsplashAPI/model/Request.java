package testFramework.unsplashAPI.model;

import java.util.Map;

public class Request {
    private String url;
    private Map<String, String> headers;
    private RequestMethod method;
    private String body;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Request{" +
                "url='" + url + '\'' +
                ", headers=" + headers +
                ", method=" + method +
                ", body='" + body + '\'' +
                '}';
    }
}

