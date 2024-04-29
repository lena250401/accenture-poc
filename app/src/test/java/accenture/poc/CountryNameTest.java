package accenture.poc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accenture.poc.model.CountryName;

public class CountryNameTest {
    private CountryName testCountryName;
    @BeforeEach
    public void setupTests(){
        testCountryName = new CountryName("Finland", "Republic of Finland");
    }

    @Test
    public void getCommonTest(){
        assertEquals(testCountryName.getCommon(), "Finland");
    }

    @Test
    public void getOfficialTest(){
    assertEquals(testCountryName.getOfficial(), "Republic of Finland");
    }

    @Test
    public void equalsTest(){
        CountryName sameCountryName = new CountryName("Finland", "Republic of Finland");
        assertTrue(testCountryName.equals(sameCountryName));
    }

    @Test
    public void notEqualsTest(){
        CountryName diffCountryName = new CountryName("Finl", "Republic of Finland");
        assertFalse(testCountryName.equals(diffCountryName));
    }

    @Test
    public void toStringTest(){
        String expected = "{" +
        " common='" + testCountryName.getCommon() + "'" +
        ", official='" +  testCountryName.getOfficial() + "'" +
        "}";
        assertEquals(testCountryName.toString(), expected);
    }
}
