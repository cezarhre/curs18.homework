package ro.fasttrackit.curs18.homework.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public List<Country> allCountries(){
        return countryService.getCountries();
    }

    @GetMapping("/countries/names")
    public List<String> countryName(){
        return countryService.getCountryNames();
    }

    @GetMapping("/countries/<countryId>/capital")
    public Optional<String> countriesCapital(){
        return countryService.getCountryCapital("Romania");
    }

    @GetMapping("/countries/<countryId>/population")
    public Optional<Long> countryPopulation(){
        return countryService.getCountryPopulation("Romania");
    }

    @GetMapping("continents/<continentName>/countries")
    public List<Country> countryContinent(){
        return countryService.getCountriesContinent("Asia");
    }

    @GetMapping("/countries/<countryId>/neighbours")
    public Optional<List<String>> CountriesNeighbour(){
        return countryService.getCountriesNeighbour("Romania");
    }

    @GetMapping("/continents/<continentName>/countries?minPopulation=<minimum population>")
    public List<Country> minMaxPopulation(){
        return countryService.getCountriesPopulationLargerMin("Europe",20000000,100000000);
    }

    @GetMapping("/countries?includeNeighbour=<includedNeighbourCode>&excludeNeighbour=<excludedNeighbourCode>")
    public List<Country> checkNeighbour(){
        return countryService.getCountriesCheckNeighbour("ITA","DEU");
    }
}