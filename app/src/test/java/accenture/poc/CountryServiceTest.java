package accenture.poc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import accenture.poc.services.CountryService;

public class CountryServiceTest {
    CountryService countryService;
    HttpClient mockHttpClient;
    HttpResponse<String> mockHttpResponse;

    @BeforeEach
    public void setUp() throws IOException, InterruptedException {
        countryService = new CountryService();
        mockHttpClient = mock(HttpClient.class);
        countryService.setClient(mockHttpClient);

        mockHttpResponse = mock(HttpResponse.class);


        when(mockHttpClient.send(HttpRequest.newBuilder().uri(URI.create("https://restcountries.com/v3.1/all")).build(), BodyHandlers.ofString())).thenReturn(mockHttpResponse);
        when(mockHttpResponse.body()).thenReturn("[{\"name\":{\"common\":\"Macau\",\"official\":\"Macao Special Administrative Region of the People's Republic of China\"},\"continents\":[\"Asia\"],\"region\":\"Asia\",\"borders\":[\"MCO\"],\"area\":30.0,\"population\":649342,\"countryCode\":\"MAC\",\"populationDensity\":21644.732},{\"name\":{\"common\":\"Monaco\",\"official\":\"Principality of Monaco\"},\"continents\":[\"Europe\"],\"region\":\"Europe\",\"borders\":null,\"area\":2.02,\"population\":39244,\"countryCode\":\"MCO\",\"populationDensity\":19427.723}]");
    }

    @Test
    public void getAllCountriesTest() throws Exception{
        assertEquals(countryService.getAllCountries().length, 2);
        
    }

    @Test
    public void getCountryByDescendingPopulationDensityTest() throws Exception {
        assertEquals(countryService.getCountryByDescendingPopulationDensity()[0].getCountryCode(), "MAC");
    }

    @Test
    public void getAsianCountryWithMostBorderingCountriesOfDifferentRegionTest(){
        assertEquals(countryService.getAsianCountryWithMostBorderingCountriesOfDifferentRegion().getCountryCode(), "MAC");
    }
}
