package com.revature.planetarium.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TestUtilities {

    /*
        This works for now, but it would be ideal to have a reset solution that does not require
        the Planetarium to be up and running for the Junit tests
     */
    public static void resetDatabase() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/reset"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpClient client = HttpClient.newHttpClient();
        client.send(request, HttpResponse.BodyHandlers.ofString());
    }

}
