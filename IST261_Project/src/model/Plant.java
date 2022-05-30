package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Plant implements careInstructions, Serializable, Comparable {
    private String plantType;
    private String plantDescription;

    public Plant(String type, String description) {
        this.plantType = type;
        this.plantDescription = description;
    }

    public Plant() {
        this.plantType = "plantType";
        this.plantDescription = "plantDescription";
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public String getPlantDescription() {
        return plantDescription;
    }

    public void setPlantDescription(String plantDescription) {
        this.plantDescription = plantDescription;
    }

    @Override
    public String toString() {
        return plantType;
    }

    @Override
    public void displayWaterInstructions() {
        if (plantType == "succulent") {
            System.out.println("Succulents prefer dry soil. Allow to dry out completely between waterings.");
        } else {
            System.out.println("Keep soil moist but not saturated. Refer to plant description for details.");
        }
    }

    @Override
    public void displayIdealLight() {
        if (plantType == "succulent") {
            System.out.println("Succulents love lots of light.");
        } else {
            System.out.println("Many plants prefer indirect sunlight. Refer to plant description for details.");
        }

    }

    @Override
    public void displayIdealSoil() {
        if (plantType == "succulent") {
            System.out.println("Succulents grow best in porous, sandy potting soil.");
        } else {
            System.out.println("Any indoor potting soil will do.");
        }
    }

    @Override
    public int compareTo(Object o) {
        int result;
        result = plantType.compareTo(o.toString());
        return result;
    }
}
