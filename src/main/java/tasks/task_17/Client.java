package tasks.task_17;

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

        request.getHeaders().entrySet().forEach(e -> {
            builder.header(e.getKey(), e.getValue());
        });

        switch (request.getMethod()) {
            case POST: builder.POST(HttpRequest.BodyPublishers.ofString(request.getBody(), StandardCharsets.UTF_8));
            break;
            case GET: builder.GET();
            break;
        }

        System.out.println("Call\t" + request);

        HttpResponse<String> httpResponse = Client.httpClient.send(builder.build(), HttpResponse.BodyHandlers.ofString());

        Response response = new Response();
        response.setBody(httpResponse.body());
        response.setStatusCode(httpResponse.statusCode());

        System.out.println(response);
        return response;
    }
}
