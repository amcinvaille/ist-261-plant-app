package model;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class PlantTreeSet implements Serializable{
    private TreeSet<Plant> plantSet = new TreeSet<Plant>();
    private String listOfPlantTypesFileName = "listOfPlantTypes.ser";
    private ArrayList<Plant> listOfPlantTypes = new ArrayList<Plant>();

    public PlantTreeSet() {
/*
        Plant bambinoPlant = new Plant("Bambino Plant", "A Bambino is a dwarf fiddle leaf fig. Bambinos are somewhat needy and difficult to care for.");
        Plant pothos = new Plant("Pothos", "Also known as Devil's Ivy, Pothos is a trailing vine with heart-shaped green leaves. Toxic to animals.");
        Plant spiderPlant = new Plant("Spider Plant", "Has long narrow green leaves usually striped with white or ivory and produce tufts of plantlets on long hanging stems.");
        Plant zzPlant = new Plant("Zanzibar Gem", "Often called ZZ Plant, this is one of the easiest houseplants to care for.");
        plantSet.add(bambinoPlant);
        plantSet.add(pothos);
        plantSet.add(spiderPlant);
        plantSet.add(zzPlant);
        System.out.println("Test PlantType Set created");
        System.out.println("The PlantSet is: " + plantSet);
        */
        this.readPlantTypeListFile();
        if(plantSet.isEmpty() || plantSet == null){
            this.createTestPlantTypeList();
            this.writePlantTypeSetFile();
            this.readPlantTypeListFile();

        }
    }


    public void writePlantTypeSetFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(listOfPlantTypesFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(plantSet);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createTestPlantTypeList() {
        //PlantEntryList thePlantList = new PlantEntryList();
        //thePlantList.setPlantEntryList(thePlantList.getListOfPlants());
        Plant bambinoPlant = new Plant("Bambino Plant", "A Bambino is a dwarf fiddle leaf fig. Bambinos are somewhat needy and difficult to care for.");
        Plant pothos = new Plant("Pothos", "Also known as Devil's Ivy, Pothos is a trailing vine with heart-shaped green leaves. Toxic to animals.");
        Plant spiderPlant = new Plant("Spider Plant", "Has long narrow green leaves usually striped with white or ivory and produce tufts of plantlets on long hanging stems.");
        Plant zzPlant = new Plant("Zanzibar Gem", "Often called ZZ Plant, this is one of the easiest houseplants to care for.");
        listOfPlantTypes.add(bambinoPlant);
        listOfPlantTypes.add(pothos);
        listOfPlantTypes.add(spiderPlant);
        listOfPlantTypes.add(zzPlant);
        plantSet.addAll(listOfPlantTypes);
        System.out.println("Test PlantType Set created");
        System.out.println("The PlantSet is: " + plantSet.toString());
    }


    public void readPlantTypeListFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(listOfPlantTypesFileName);
            in = new ObjectInputStream(fis);
            plantSet = (TreeSet) in.readObject();
            in.close();
            if (!plantSet.isEmpty()) {
                System.out.println("There are plant types in the plant list");
            }
        } catch (FileNotFoundException fne) {
            System.out.println("File was not found, a new one will be created");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }


    public TreeSet<Plant> getPlantSet() {
        return plantSet;
    }

    public void setPlantSet(TreeSet<Plant> plantSet) {
        this.plantSet = plantSet;
    }
}
