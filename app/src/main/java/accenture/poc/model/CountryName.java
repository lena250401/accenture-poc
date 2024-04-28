package accenture.poc.model;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryName {
    private String common;
    private String official;

    public CountryName() {
    }

    public CountryName(String common, String official) {
        this.common = common;
        this.official = official;
    }

    public String getCommon() {
        return this.common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public String getOfficial() {
        return this.official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }

    public CountryName common(String common) {
        setCommon(common);
        return this;
    }

    public CountryName official(String official) {
        setOfficial(official);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CountryName)) {
            return false;
        }
        CountryName countryName = (CountryName) o;
        return Objects.equals(common, countryName.common) && Objects.equals(official, countryName.official);
    }

    @Override
    public int hashCode() {
        return Objects.hash(common, official);
    }

    @Override
    public String toString() {
        return "{" +
            " common='" + getCommon() + "'" +
            ", official='" + getOfficial() + "'" +
            "}";
    }

    
    
}
