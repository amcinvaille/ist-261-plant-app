package view;

import controller.PlantEntryCntrl;
import controller.PlantEntryTableCntrl;
import controller.PlantSetCntrl;
import model.Plant;
import model.PlantEntry;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.TreeSet;

public class PlantEntryUI extends JFrame {
    private JLabel titleLabel;

    private JPanel plantEntryPanel;
    private JPanel titlePanel;
    private JButton addBtn;
    private JButton updateBtn;
    private JButton deleteBtn;
    private JButton saveBtn;
    private JButton previousBtn;
    private JButton nextBtn;

    private JTextField soilTxt;
    private JTextField lightTxt;
    private JTextField waterTxt;
    private JTextField pottedTxt;
    private JTextField fertilizerTxt;
    private JLabel notesLbl;
    private JLabel fertilizerLbl;
    private JLabel soilLbl;
    private JLabel lightLbl;
    private JLabel waterLbl;
    private JLabel plantTypeLbl;
    private JLabel datePottedLbl;
    private JLabel plantNameLbl;


    private JTextField plantNameTxt;
    private JComboBox plantComboBox;
    private JTextArea notesTxtArea;
    private JButton backBtn;
    private JButton editTypeButton;

    private PlantEntryCntrl thePlantCntrl;
    private PlantSetCntrl thePlantSetCntrl;
    private int index = 0;
    private String change_ind;

    //Create init method to call in constructor to clean it up
    public PlantEntryUI(PlantEntryCntrl plantCntrl, int row) {
        index = row;
        this.thePlantCntrl = plantCntrl;
        initDetailView();

    }

    public void initDetailView() {
        this.setSize(1000, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(titlePanel);
        saveBtn.setVisible(false);
        setUpComboBox();
        setPlantEntry(index);

        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index == thePlantCntrl.getThePlantEntryList().getPlantEntryList().size() - 1) {
                    index = 0;
                } else {
                    index++;
                }
                setPlantEntry(index);

            }
        });
        previousBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index == 0) {
                    index = thePlantCntrl.getThePlantEntryList().getPlantEntryList().size() - 1;
                } else {
                    index--;
                }
                setPlantEntry(index);

            }
        });
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPlantWindow();
                change_ind = "add";
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableFields();
                change_ind = "update";

            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //send confirmation message first
                thePlantCntrl.deletePlant(index);
                if (thePlantCntrl.getThePlantEntryList().getPlantEntryList().size() == 0) {
                    newPlantWindow();
                } else {
                    if (index == 0) {
                        index = index = thePlantCntrl.getThePlantEntryList().getPlantEntryList().size() - 1;
                    } else {
                        index--;
                    }
                    setPlantEntry(index);
                }
            }
        });

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TreeSet<Plant> plants = thePlantCntrl.getThePlantSetCntrl().getThePlantSet().getPlantSet();
                System.out.println(plants);
                PlantEntry newPlant = new PlantEntry();
                newPlant.setPlantName(plantNameTxt.getText());
                String plantName = (String) plantComboBox.getSelectedItem();
                for (Plant p: plants) {
                    if (p.getPlantType().equals(plantName)) {
                        newPlant.setEntryPlant(p);
                    }
                }

                newPlant.setDatePotted(pottedTxt.getText());
                newPlant.setFertilizerType(fertilizerTxt.getText());
                newPlant.setLightLevel(lightTxt.getText());
                newPlant.setSoilType(soilTxt.getText());
                newPlant.setLastWatered(waterTxt.getText());
                newPlant.setNotes(notesTxtArea.getText());

                if (change_ind.equals("add")) {
                    thePlantCntrl.addNewPlantEntry(newPlant);
                    index = thePlantCntrl.getThePlantEntryList().getPlantEntryList().size() - 1;
                } else {
                    thePlantCntrl.getThePlantEntryList().getPlantEntryList().set(index, newPlant);
                    thePlantCntrl.getThePlantEntryList().writePlantListFile();
                }

                //Set screen
                setPlantEntry(index);
                disableFields();
            }
        });
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlantEntryTableCntrl plantEntryTableCntrl = thePlantCntrl.getThePlantEntryTableCntrl();
                plantEntryTableCntrl.showPlantEntryTable(plantEntryTableCntrl.getCurrentAcct());
            }
        });
        editTypeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thePlantSetCntrl = new PlantSetCntrl(thePlantCntrl);
            }
        });

    }

    public void newPlantWindow() {
        plantNameTxt.setText("");
        waterTxt.setText("");
        lightTxt.setText("");
        soilTxt.setText("");
        fertilizerTxt.setText("");
        pottedTxt.setText("");
        notesTxtArea.setText("");

        enableFields();
    }

    public void setPlantEntry(int index) {
        PlantEntry plant = thePlantCntrl.getThePlantEntryList().getPlantEntryList().get(index);

        plantNameTxt.setText(plant.getPlantName());
        waterTxt.setText(plant.getLastWatered());
        lightTxt.setText(plant.getLightLevel());
        soilTxt.setText(plant.getSoilType());
        fertilizerTxt.setText(plant.getFertilizerType());
        pottedTxt.setText(plant.getDatePotted());
        notesTxtArea.setText(plant.getNotes());
        plantComboBox.setSelectedItem(plant.getEntryPlant().getPlantType());


    }

    public void setUpComboBox() {
        TreeSet<Plant> plants = thePlantCntrl.getThePlantSetCntrl().getThePlantSet().getPlantSet();

        plantComboBox.removeAllItems();
        for (Plant p : plants) {
            plantComboBox.addItem(p.getPlantType());
        }
    }

    public void enableFields() {
        plantNameTxt.setEditable(true);
        waterTxt.setEditable(true);
        lightTxt.setEditable(true);
        soilTxt.setEditable(true);
        fertilizerTxt.setEditable(true);
        pottedTxt.setEditable(true);
        notesTxtArea.setEditable(true);
        plantComboBox.setEnabled(true);
        plantComboBox.setEditable(true);

        nextBtn.setEnabled(false);
        previousBtn.setEnabled(false);
        addBtn.setEnabled(false);
        updateBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        saveBtn.setVisible(true);
    }

    public void disableFields() {
        plantNameTxt.setEditable(false);
        waterTxt.setEditable(false);
        lightTxt.setEditable(false);
        soilTxt.setEditable(false);
        fertilizerTxt.setEditable(false);
        pottedTxt.setEditable(false);
        notesTxtArea.setEditable(false);
        plantComboBox.setEnabled(false);
        plantComboBox.setEditable(false);

        nextBtn.setEnabled(true);
        previousBtn.setEnabled(true);
        addBtn.setEnabled(true);
        updateBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
        saveBtn.setVisible(false);
    }

    public void setChangeInd(String changeInd) {
        this.change_ind = changeInd;
    }

}
