package accenture.poc.services;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;

import accenture.poc.model.Country;

public class CountryService {
    private HttpClient client;
    private final String baseURL = "https://restcountries.com/v3.1";
    

    public CountryService() {
        this.client = HttpClient.newHttpClient();
    }

    private HttpRequest apiRequest(String path){
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURL + path)).build();
        return request;
    }

    public Country[] getAllCountries() throws Exception{
       HttpRequest request = apiRequest("/all");
       HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

       ObjectMapper objectMapper = new ObjectMapper();
       Country[] countries = objectMapper.readValue(response.body(), Country[].class);

       return countries;
    }

}
