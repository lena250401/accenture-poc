package accenture.poc.model;

import java.util.Comparator;

public class PopulationDensityComparator implements Comparator<Country> {
    @Override
    public int compare(Country c1, Country c2){
        return Float.compare(c2.getPopulationDensity(), c1.getPopulationDensity());
    }
}
