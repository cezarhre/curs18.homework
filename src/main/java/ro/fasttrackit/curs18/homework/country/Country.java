package ro.fasttrackit.curs18.homework.country;

import java.util.*;

public record Country(int id, String name, String capital, long population, long area,
                      String continent, List<String> neighbour) {

    public int getId() {
        return id;
    }

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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Country) obj;
        return this.id == that.id &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.capital, that.capital) &&
                this.population == that.population &&
                this.area == that.area &&
                Objects.equals(this.continent, that.continent) &&
                Objects.equals(this.neighbour, that.neighbour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, capital, population, area, continent, neighbour);
    }

    @Override
    public String toString() {
        return "Country[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "capital=" + capital + ", " +
                "population=" + population + ", " +
                "area=" + area + ", " +
                "continent=" + continent + ", " +
                "neighbour=" + neighbour + ']';
    }

}