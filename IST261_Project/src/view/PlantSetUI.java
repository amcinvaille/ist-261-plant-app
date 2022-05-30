package view;

import controller.PlantEntryCntrl;
import controller.PlantSetCntrl;
import model.Plant;
import model.PlantTreeSet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class PlantSetUI extends JFrame{
    private JButton saveButton;
    private JPanel panel1;
    private JButton deleteButton;
    private JTextField nameTxt;
    private JTextArea descriptionTxt;
    private JLabel plantLabel;
    private JLabel descripLabel;
    private JButton backButton;
    private JButton addButton;
    private JComboBox plantCombo;

    private PlantSetCntrl thePlantSetCntrl;
    private PlantEntryCntrl thePlantCntrl;

    public PlantSetUI(PlantSetCntrl plantSetCntrl) {
        this.thePlantSetCntrl = plantSetCntrl;
        this.initAddPlant();
        this.setUpComboBox();

    }

    public void initAddPlant() {
        this.setSize(500, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(panel1);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Plant plant = (Plant) plantCombo.getSelectedItem();

                thePlantSetCntrl.removePlant(plant);
                thePlantSetCntrl.setThePlantSet(thePlantSetCntrl.getThePlantSet());
                setUpComboBox();

            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plant newPlant = new Plant();
                newPlant.setPlantType(nameTxt.getText());
                newPlant.setPlantDescription(descriptionTxt.getText());

                thePlantSetCntrl.addNewPlant(newPlant);

                saveButton.setEnabled(false);
                nameTxt.setVisible(false);
                deleteButton.setEnabled(true);
                descriptionTxt.setText("");
                plantCombo.setVisible(true);
                thePlantSetCntrl.setThePlantSet(thePlantSetCntrl.getThePlantSet());
                setUpComboBox();
            }

        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveButton.setEnabled(true);
                plantCombo.setVisible(false);
                deleteButton.setEnabled(false);
                nameTxt.setVisible(true);
                descriptionTxt.setText("");

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thePlantSetCntrl.showPlantEntryUI();
                thePlantSetCntrl.getThePlantSetUI().dispose();
            }
        });

        plantCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plant plant = (Plant) plantCombo.getSelectedItem();
                if (plant != null) {
                    descriptionTxt.setText(plant.getPlantDescription());
                } else { descriptionTxt.setText(""); }
            }
        });
    }

    public void setUpComboBox() {
        TreeSet<Plant> plants = thePlantSetCntrl.getThePlantSet().getPlantSet();

        plantCombo.removeAllItems();
        for (Plant p : plants) {
            plantCombo.addItem(p);
        }


    }
}

