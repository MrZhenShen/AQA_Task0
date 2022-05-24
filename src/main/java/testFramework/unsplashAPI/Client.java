package testFramework.unsplashAPI;

import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import testFramework.unsplashAPI.model.Request;
import testFramework.unsplashAPI.model.Response;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Client {
    static HttpClient httpClient = HttpClient.newHttpClient();

    public static Response execute(Request request) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest.Builder builder = HttpRequest
                .newBuilder()
                .uri(new URI(request.getUrl()));

        request.getHeaders().forEach(builder::header);

        switch (request.getMethod()) {
            case POST:
                builder.POST(HttpRequest.BodyPublishers.ofString(request.getBody(), StandardCharsets.UTF_8));
                break;
            case GET:
                builder.GET();
                break;
            case PUT:
                builder.PUT(HttpRequest.BodyPublishers.ofString(request.getBody(), StandardCharsets.UTF_8));
                break;
            case DELETE:
                builder.DELETE();
                break;
        }

        System.out.println("Call\t" + request);

        HttpResponse<String> httpResponse = Client.httpClient.send(builder.build(), HttpResponse.BodyHandlers.ofString());

        Response response = new Response();
        response.setBody(httpResponse.body());
        response.setStatusCode(httpResponse.statusCode());

        if(response.getStatusCode() < 200 & response.getStatusCode() > 199) {
            throw new InterruptedException();
        }

        return response;
    }

    public static <T extends Response> T parseJSONToObject(Response response, Class<T> responseClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        T parsedResponse = null;
        try {
            parsedResponse = objectMapper.readValue(response.getBody(), responseClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parsedResponse;
    }
}
