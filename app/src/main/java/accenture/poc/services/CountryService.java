package accenture.poc.services;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import accenture.poc.model.Country;
import accenture.poc.model.PopulationDensityComparator;

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

    public Country[] getCountryByDescendingPopulationDensity(){
         
            Country[] countries = new Country[0];
            try {
                countries = getAllCountries();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Arrays.sort(countries, new PopulationDensityComparator());
            return countries;
    }


    public Country getAsianCountryWithMostBorderingCountriesOfDifferentRegion(){
        Country[] countries = new Country[0];
            try {
                countries = getAllCountries();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    
        Map<String, Country> countryMap = new HashMap<>();
        List<Country> asianCountries = new ArrayList<>();

        for(int i = 0; i < countries.length; i++){
            countryMap.put(countries[i].getCountryCode(), countries[i]);
            if(Arrays.asList(countries[i].getContinents()).contains("Asia")){
                asianCountries.add(countries[i]);
            }
    
        }
        Country result = null;
        int count = Integer.MIN_VALUE;
        for(Country country : asianCountries){
            if(country.getBorders() == null) continue;
            int temp = 0;
            for(String border : country.getBorders()){
                if(!countryMap.get(border).getRegion().equals(country.getRegion())) temp++;
            }
            if(temp > count){
                count = temp;
                result = country;
            }
        }
        return result;
    }

}
