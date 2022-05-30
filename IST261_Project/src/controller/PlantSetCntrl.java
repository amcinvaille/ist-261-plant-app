package controller;

import model.*;
import view.PlantSetUI;

import java.util.ArrayList;

public class PlantSetCntrl {
    private PlantSetUI thePlantSetUI;
    private PlantTreeSet thePlantSet;
    private PlantEntryCntrl thePlantCntrl;

    public PlantSetCntrl() {
        thePlantSet = new PlantTreeSet();
        thePlantSetUI = new PlantSetUI(this);
        showPlantSetUI();
    }

    public PlantSetCntrl(PlantEntryCntrl plantCntrl) {
        this.thePlantCntrl = plantCntrl;
        thePlantSet = new PlantTreeSet();
        thePlantSetUI = new PlantSetUI(this);
        showPlantSetUI();
    }


    public void showPlantSetUI() {
        thePlantSetUI = new PlantSetUI(this);
        thePlantSetUI.setVisible(true);

    }

    public void showPlantEntryUI() {
        this.thePlantCntrl.setThePlantSetCntrl(this);
        this.thePlantCntrl.showPlantEntryUI(thePlantCntrl.getRow());
    }


    public PlantSetUI getThePlantSetUI() {
        return thePlantSetUI;
    }

    public void setThePlantSetUI(PlantSetUI plantUI) {
        this.thePlantSetUI = plantUI;
    }

    public PlantTreeSet getThePlantSet() {
        return thePlantSet;
    }

    public void setThePlantSet(PlantTreeSet plantSet) {
        this.thePlantSet = plantSet;
    }


    public void addNewPlant(Plant plant) {
        this.thePlantSet.getPlantSet().add(plant);
        this.thePlantSet.writePlantTypeSetFile();
        this.thePlantSet.readPlantTypeListFile();
        System.out.println("Plant written to file");
    }

    public void removePlant(Plant plant) {
        int i = 0;
        ArrayList<PlantEntry> list = this.thePlantCntrl.getThePlantEntryList().getPlantEntryList();
        for (PlantEntry p: list) {
            if (p.getEntryPlant().getPlantType().equalsIgnoreCase(plant.getPlantType())) {
                i++;
            }
        }
        if (i <= 0) {
            this.thePlantSet.getPlantSet().remove(plant);
            this.thePlantSet.writePlantTypeSetFile();
            this.thePlantSet.readPlantTypeListFile();
            System.out.println("Plant deleted from file");
        }
        else {
            System.out.println("Plant cannot be deleted");
        }
    }


}
