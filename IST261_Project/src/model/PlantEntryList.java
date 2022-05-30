package model;

import java.io.*;
import java.util.ArrayList;

public class PlantEntryList implements Serializable {
    private ArrayList<PlantEntry> plantEntryList = new ArrayList<>();
    //private PlantList plantList = new PlantList();
    private PlantTreeSet plantList = new PlantTreeSet();
    private String listOfPlantsFileName = "listOfPlants.ser";
    private ArrayList<PlantEntry> listOfPlants = new ArrayList<>();


    public PlantEntryList() {
        this.readPlantListFile();
        if(this.listOfPlants.isEmpty() || this.listOfPlants == null) {
            this.createTestPlantList();
            this.writePlantListFile();
            this.readPlantListFile();
        }

    }

    public void writePlantListFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(listOfPlantsFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listOfPlants);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createTestPlantList() {
        Plant arr[] = new Plant[plantList.getPlantSet().size()];
        plantList.getPlantSet().toArray(arr);
        PlantEntry plant1 = new PlantEntry(arr[1], "Pothos 1", "August 2020", "Miracle grow", "10/16/21", "Noot - with water", "Bright, indirect light", "Pruned on 10/12/21");
        PlantEntry plant2 = new PlantEntry(arr[1], "Baby pothos", "October 2021", "Miracle grow", "10/16/21", "Noot - with water", "Bright, indirect light", "First propogation from Pothos 1. Currently has 4 leaves.");
        PlantEntry plant3 = new PlantEntry(arr[0], "Childish Bambino", "March 2021", "Miracle grow", "10/16/21", "Noot - with water", "Bright, indirect light", "");

        listOfPlants.add(plant1);
        listOfPlants.add(plant2);
        listOfPlants.add(plant3);
    }

    public void readPlantListFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(listOfPlantsFileName);
            in = new ObjectInputStream(fis);
            listOfPlants = (ArrayList) in.readObject();
            in.close();
            if (!listOfPlants.isEmpty()) {
                System.out.println("There are plants in the plant list");
            }
        } catch (FileNotFoundException fne) {
            System.out.println("File was not found, a new one will be created");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<PlantEntry> getPlantEntryList() {
        return plantEntryList;
    }

    public void setPlantEntryList(ArrayList<PlantEntry> plantEntryList) {
        this.plantEntryList = plantEntryList;
    }

    public PlantTreeSet getPlantList() {
        return plantList;
    }

    public void setPlantList(PlantTreeSet plants) {
        this.plantList = plants;
    }

    public String getListOfPlantsFileName() {
        return listOfPlantsFileName;
    }

    public void setListOfPlantsFileName(String listOfPlantsFileName) {
        this.listOfPlantsFileName = listOfPlantsFileName;
    }

    public ArrayList<PlantEntry> getListOfPlants() {
        return listOfPlants;
    }

    public void setListOfPlants(ArrayList<PlantEntry> listOfPlants) {
        this.listOfPlants = listOfPlants;
    }
}
