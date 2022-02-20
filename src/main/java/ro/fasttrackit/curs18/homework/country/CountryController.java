package ro.fasttrackit.curs18.homework.country;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public List<Country> getCountries(){
        return countryService.getCountries();
    }

    @GetMapping("/countries/names")
    public List<String> getCountryNames(){
        return countryService.getCountryNames();
    }

    @GetMapping("/countries/{countryId}/capital")
    public Optional<String> getCountryCapital(@PathVariable int countryId){
        return countryService.getCountryCapital(countryId);
    }

    @GetMapping("/countries/{countryId}/population")
    public Optional<Long> getCountryPopulation(@PathVariable int countryId){
        return countryService.getCountryPopulation(countryId);
    }

    @GetMapping("/continents/{continentName}/countries")
    public List<Country> getCountriesContinent(@PathVariable String continentName){
        return countryService.getCountriesContinent(continentName);
    }

    @GetMapping("/countries/{countryId}/neighbours")
    public Optional<List<String>> getCountriesNeighbour(@PathVariable int countryId){
        return countryService.getCountriesNeighbour(countryId);
    }

    @GetMapping("/continents/{continentName}/countries?minPopulation=<minimum population>")
    public List<Country> getCountriesPopulationLargerMin(@PathVariable String continentName,
                                                         @PathVariable int minPop,
                                                         @PathVariable int maxPop){
        return countryService.getCountriesPopulationLargerMin(continentName,minPop,maxPop);
    }

    @GetMapping("/countries?includeNeighbour={includedNeighbourCode}&excludeNeighbour={excludedNeighbourCode}")
    public List<Country> getCountriesCheckNeighbour(@PathVariable String tara1,
                                                    @PathVariable String tara2){
        return countryService.getCountriesCheckNeighbour(tara1,tara2);
    }
}