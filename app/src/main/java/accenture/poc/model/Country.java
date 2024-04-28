package accenture.poc.model;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country{
    private CountryName name;
    private String countryCode; 
    private String[] continents;
    private String region;
    private String[] borders;
    private float area;
    private int population;
    private float populationDensity;

    @JsonCreator
    public Country(@JsonProperty("name") CountryName name,@JsonProperty("cca3") String countryCode,@JsonProperty("continents") String[] continents,@JsonProperty("region") String region,@JsonProperty("borders") String[] borders,@JsonProperty("area") float area,@JsonProperty("population")  int population) {
        this.name = name;
        this.countryCode = countryCode;
        this.continents = continents;
        this.region = region;
        this.borders = borders;
        this.area = area;
        this.population = population;
        this.populationDensity = this.population/this.area;
    }

    public Country() {
    }

    public CountryName getName() {
        return this.name;
    }

    public void setName(CountryName name) {
        this.name = name;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String[] getContinents() {
        return this.continents;
    }

    public void setContinents(String[] continents) {
        this.continents = continents;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String[] getBorders() {
        return this.borders;
    }

    public void setBorders(String[] borders) {
        this.borders = borders;
    }

    public float getArea() {
        return this.area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public float getPopulationDensity(){
        return populationDensity;
    }

    public void setPopulationDensity(float populationDensity){
        this.populationDensity = populationDensity;
    }


    public Country name(CountryName name) {
        setName(name);
        return this;
    }

    public Country countryCode(String countryCode) {
        setCountryCode(countryCode);
        return this;
    }

    public Country continents(String[] continents) {
        setContinents(continents);
        return this;
    }

    public Country region(String region) {
        setRegion(region);
        return this;
    }

    public Country borders(String[] borders) {
        setBorders(borders);
        return this;
    }

    public Country area(float area) {
        setArea(area);
        return this;
    }

    public Country population(int population) {
        setPopulation(population);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Country)) {
            return false;
        }
        Country country = (Country) o;
        return Objects.equals(name, country.name) && Objects.equals(countryCode, country.countryCode) && Objects.equals(continents, country.continents) && Objects.equals(region, country.region) && Objects.equals(borders, country.borders) && area == country.area && population == country.population;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, countryCode, continents, region, borders, area, population);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", countryCode='" + getCountryCode() + "'" +
            ", continents='" + getContinents() + "'" +
            ", region='" + getRegion() + "'" +
            ", borders='" + getBorders() + "'" +
            ", area='" + getArea() + "'" +
            ", population='" + getPopulation() + "'" +
            "}";
    }
    
    
}
