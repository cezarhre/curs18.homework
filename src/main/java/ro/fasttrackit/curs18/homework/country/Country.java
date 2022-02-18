package ro.fasttrackit.curs18.homework.country;

import java.util.*;

public record Country(int id, String name, String capital, long population, long area,
                      String continent, List<String> neighbour) {

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public String getCapital() {
        return capital;
    }

    public List<String> getNeighbour() {
        return neighbour;
    }

    public long getPopulation() {
        return population;
    }
}