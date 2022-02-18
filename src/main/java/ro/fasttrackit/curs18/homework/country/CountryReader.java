package ro.fasttrackit.curs18.homework.country;

import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

@Component
public class CountryReader {

    public CountryReader(){
    }

    public List<Country> getCountries() {
        int id = 0;
        List<Country> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("files/countries.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(readCountryFromLine(++id,line));
            }
        } catch (IOException e){
            System.out.println("File not found");
        }
        return result;
    }

    public Country readCountryFromLine(int id, String line) {
        String[] tokens = line.split(Pattern.quote("|"));
        List<String> neighbours;
        if (tokens.length > 5) {
            neighbours = List.of(tokens[5].split(Pattern.quote("~")));
        } else {
            neighbours = List.of();
        }
        return new Country(id,
                tokens[0],
                tokens[1],
                Long.parseLong(tokens[2]),
                Long.parseLong(tokens[3]),
                tokens[4],
                neighbours);
    }
}