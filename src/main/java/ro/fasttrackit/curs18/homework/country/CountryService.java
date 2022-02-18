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

    public String getCountryCapital(String tara) {
        return countries.stream()
                .filter(country -> country.getName().equalsIgnoreCase(tara))
                .map(Country::getCapital)
                .collect(Collectors.joining());
    }

    public Optional<Long> getCountryPopulation(String tara) {
        return countries.stream()
                .filter(country -> country.getName().equalsIgnoreCase(tara))
                .map(Country::getPopulation)
                .findFirst();
    }

    public List<Country> getCountriesContinent(String conti){
        return countries.stream()
                .filter(continent -> continent.getContinent().equalsIgnoreCase(conti))
                .sorted(Comparator.comparing(Country::getContinent))
                .collect(Collectors.toList());
    }

    public List<List<String>> getCountriesNeighbour(String tara){
        return countries.stream()
                .filter(country -> country.getName().equalsIgnoreCase(tara))
                .map(Country::getNeighbour)
                .collect(Collectors.toList());
    }

    public List<Country> getCountriesPopulationLargerMin(String conti){
        return countries.stream()
                .filter(country -> country.getContinent().equalsIgnoreCase(conti))
                .sorted(Comparator.comparing(Country::getContinent))
                .filter(country -> country.getPopulation() > 20000000)
                .filter(country -> country.getPopulation() < 100000000)
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
