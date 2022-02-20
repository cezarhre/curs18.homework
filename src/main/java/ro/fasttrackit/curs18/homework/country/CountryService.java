package ro.fasttrackit.curs18.homework.country;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CountryService {
    private final List<Country> countries;

    public CountryService(CountryReader countryReader) {
        this.countries = countryReader.getCountries();
    }

    public List<Country> getCountries() {
        return countries;
    }

    public List<String> getCountryNames() {
        return countries.stream()
                .map(Country::getName)
                .collect(Collectors.toList());
    }

    public Optional<String> getCountryCapital(int countryId) {
        return countries.stream()
                .filter(country -> country.getId() == countryId)
                .map(Country::getCapital)
                .findFirst();
    }

    public Optional<Long> getCountryPopulation(int countryId) {
        return countries.stream()
                .filter(country -> country.getId() == countryId)
                .map(Country::getPopulation)
                .findFirst();
    }

    public List<Country> getCountriesContinent(String continentName){
        return countries.stream()
                .filter(continent -> continent.getContinent().equalsIgnoreCase(continentName))
                .collect(Collectors.toList());
    }

    public Optional<List<String>> getCountriesNeighbour(int countryId){
        return countries.stream()
                .filter(country -> country.getId() == countryId)
                .map(Country::getNeighbour)
                .findFirst();
    }

    public List<Country> getCountriesPopulationLargerMin(String continentName, int minPop, int maxPop){
        return countries.stream()
                .filter(country -> country.getContinent().equalsIgnoreCase(continentName))
                .sorted(Comparator.comparing(Country::getContinent))
                .filter(country -> country.getPopulation() > minPop)
                .filter(country -> country.getPopulation() < maxPop)
                .collect(Collectors.toList());
    }

    public List<Country> getCountriesCheckNeighbour(String tara1, String tara2){
        return countries.stream()
                .filter(country -> country.getNeighbour().contains(tara1))
                .filter(country -> !country.getNeighbour().contains(tara2))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "CountryService{" +
                "countries=" + countries +
                '}';
    }
}
