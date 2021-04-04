package org.loclique.lambda;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Path("/crypto")
public class processor {
    @ConfigProperty(name="API_KEY")
    String  API_KEY;

    private final String BASE_URL="https://api.nomics.com/v1/currencies/ticker?key=%s&ids=%s";
    @Path("/getCryptoValue/{cryptoName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCryptoValue(@PathParam String cryptoName){
        HttpResponse<String> response = null;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(BASE_URL,API_KEY,cryptoName)))
                .build();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        if (response != null) {
            return Response.ok(response.body()).build();
        }
        return Response.ok("NO DATA FOUND").build();
    }
}