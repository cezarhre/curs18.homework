package ro.fasttrackit.curs18.homework.country;

import java.util.List;

public class CountryMain {
    public static void main(String[] args) {
        CountryReader countryReader = new CountryReader();
        List<Country> countries = countryReader.getCountries();
        System.out.println(countries);
        CountryService countryService = new CountryService(countryReader);
        System.out.println(countryService.getCountryNames());
        System.out.println(countryService.getCountryCapital("Romania"));
        System.out.println(countryService.getCountryPopulation("Romania"));
        System.out.println(countryService.getCountriesContinent("Asia"));
        System.out.println(countryService.getCountriesNeighbour("Romania"));
        System.out.println(countryService.getCountriesPopulationLargerMin("Europe",20000000,100000000));
        System.out.println(countryService.getCountriesCheckNeighbour("ITA","DEU"));
    }
}
