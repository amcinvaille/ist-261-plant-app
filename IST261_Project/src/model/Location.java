package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Location implements Serializable {
    private String name;
    private ArrayList<PlantEntry> plantEntries;
    private String lightLevel;

    public Location(String name, ArrayList<PlantEntry> plantEntries, String light) {
        this.name = name;
        this.plantEntries = plantEntries;
        this.lightLevel = light;
    }

    public Location(String name) {
        this.name = name;
        this.lightLevel = "lightLevel";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<PlantEntry> getPlantEntries() {
        return plantEntries;
    }

    public void setPlantEntries(ArrayList<PlantEntry> plantEntries) {
        this.plantEntries = plantEntries;
    }

    public String getLightLevel() {
        return lightLevel;
    }

    public void setLightLevel(String lightLevel) {
        this.lightLevel = lightLevel;
    }

    @Override
    public String toString() {
        return ("Location: " + name + "\nLight level: " + lightLevel + "\nPlants: " + plantEntries.toString());
    }
}
