package model;

import model.Plant;

import java.io.Serializable;

public class PlantEntry implements Serializable {
    private Plant entryPlant;
    private String plantName;
    private String datePotted;
    private String soilType;
    private String lastWatered;
    private String fertilizerType;
    private String lightLevel;
    private String notes;

    public PlantEntry(Plant plant) {
        this.entryPlant = plant;
    }

    public PlantEntry(Plant plant, String plantName, String datePotted, String soilType, String water, String fertilizer, String lightLevel, String notes) {
        this.entryPlant = plant;
        this.plantName = plantName;
        this.datePotted = datePotted;
        this.soilType = soilType;
        this.lastWatered = water;
        this.fertilizerType = fertilizer;
        this.lightLevel = lightLevel;
        this.notes = notes;
    }

    public PlantEntry() {
    }

    public Plant getEntryPlant() {
        return entryPlant;
    }

    public void setEntryPlant(Plant entryPlant) {
        this.entryPlant = entryPlant;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String name) {
        this.plantName = name;
    }

    public String getDatePotted() {
        return datePotted;
    }

    public void setDatePotted(String datePotted) {
        this.datePotted = datePotted;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public String getLastWatered() {
        return lastWatered;
    }

    public void setLastWatered(String water) {
        this.lastWatered = water;
    }

    public String getFertilizerType() {
        return fertilizerType;
    }

    public void setFertilizerType(String fertilizerType) {
        this.fertilizerType = fertilizerType;
    }

    public String getLightLevel() {
        return lightLevel;
    }

    public void setLightLevel(String lightLevel) {
        this.lightLevel = lightLevel;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return ("Plant: " + entryPlant.toString() + "\nName: " + plantName + "\nDate Potted: " + datePotted + "\nSoil Type: " + soilType + "\nLast watered: " + lastWatered + "\nLight level: " + lightLevel + "\nNotes: " + notes);
    }
}
