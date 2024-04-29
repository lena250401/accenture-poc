package accenture.poc;

import org.junit.jupiter.api.Test;

import accenture.poc.model.Country;
import accenture.poc.model.CountryName;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;

public class CountryTest {
    private Country testCountry; 

    @BeforeEach
    public void setupTests(){
        testCountry = new Country(new CountryName("Finland", "Republic of Finland"), "FIN", new String[] {"Europe"}, "Europe", new String[]{"NOR", "SEW", "RUS"}, (float)338424.0, 5530719);
    }
    @Test
    public void getCNameTest(){
        CountryName expected = new CountryName("Finland", "Republic of Finland");
        assertEquals(testCountry.getName(), expected);
    }

    @Test
    public void getCountryCodeTest(){
        assertEquals(testCountry.getCountryCode(), "FIN");
    }

    @Test
    public void getContinentsTest(){
        String[] expected = new String[]{"Europe"};
        assertTrue(Arrays.equals(testCountry.getContinents(),expected));
    }

    @Test
    public void getRegionTest(){
        assertEquals(testCountry.getRegion(), "Europe");
    }

    @Test
    public void getBordersTest(){
        String[] expected = new String[]{"NOR", "SEW", "RUS"};
        assertTrue(Arrays.equals(testCountry.getBorders(),expected));
    }

    @Test
    public void getAreaTest(){
        assertEquals(testCountry.getArea(), 338424.0);
    }

    @Test
    public void getPopulationTest(){
        assertEquals(testCountry.getPopulation(), 5530719);
    }

    @Test
    public void getPopulationDensityTest(){
        assertEquals(testCountry.getPopulationDensity(), testCountry.getPopulation()/testCountry.getArea());
    }

    @Test
    public void equalsTest(){
        Country sameCountry = new Country(new CountryName("Finland", "Republic of Finland"), "FIN", new String[] {"Europe"}, "Europe", new String[]{"NOR", "SEW", "RUS"}, (float)338424.0, 5530719);
        assertTrue(testCountry.equals(sameCountry));
    }

    @Test
    public void notEqualsTest(){
        Country diffCountry = new Country(new CountryName("Finland", "Republic of Finland"), "FN", new String[] {"Europe"}, "Europe", new String[]{"NOR", "SEW", "RUS"}, (float)338424.0, 5530719);
        assertFalse(testCountry.equals(diffCountry));
    }

    @Test
    public void notEqualsWhenEmptyTest(){
        Country diffCountry = new Country();
        assertFalse(testCountry.equals(diffCountry));
    }

    @Test
    public void toStringTest(){
        String excpeted = "{" +
        " name='" + testCountry.getName().toString() + "'" +
        ", countryCode='" + testCountry.getCountryCode() + "'" +
        ", continents='" + testCountry.getContinents().toString() + "'" +
        ", region='" + testCountry.getRegion() + "'" +
        ", borders='" + testCountry.getBorders().toString() + "'" +
        ", area='" + testCountry.getArea() + "'" +
        ", population='" + testCountry.getPopulation() + "'" +
        "}";
        assertEquals(testCountry.toString(),excpeted);
    } 


}
