package accenture.poc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accenture.poc.model.Country;
import accenture.poc.model.PopulationDensityComparator;

public class PopulationDensityComparatorTest {
    private Country c1;
    private Country c2;
    private PopulationDensityComparator populationDensityComparator;
    @BeforeEach
    public void setupTests(){
        populationDensityComparator = new PopulationDensityComparator();
        c1 = new Country();
        c2 = new Country();
    }

    @Test
    public void biggerTest(){
        c1.setPopulationDensity(1);
        c2.setPopulationDensity(3);
        assertEquals(populationDensityComparator.compare(c1, c2), 1);
    }

    @Test
    public void equalsTest(){
        c1.setPopulationDensity(1);
        c2.setPopulationDensity(1);
        assertEquals(populationDensityComparator.compare(c1, c2), 0);
    }

    @Test
    public void smallerTest(){
        c1.setPopulationDensity(3);
        c2.setPopulationDensity(1);
        assertEquals(populationDensityComparator.compare(c1, c2), -1);
    }
}
