package com.example.httpclientexplore.serviceImpl;

import com.example.httpclientexplore.service.PostalService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Service
public class PostalServiceImpl implements PostalService {

    @Value("${endpoint}")
    private String  ENDPOINT;

    @Override
    public String getPostalDetails() throws URISyntaxException, IOException, InterruptedException {
        String response = null;
        System.out.println("End Point is : " + ENDPOINT);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(ENDPOINT))
                .version(HttpClient.Version.HTTP_2)
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .GET()
                .build();

        HttpClient client = HttpClient.newBuilder().build();

        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        response = httpResponse.body();
        System.out.println(httpResponse.statusCode());
        return response;
    }
}
