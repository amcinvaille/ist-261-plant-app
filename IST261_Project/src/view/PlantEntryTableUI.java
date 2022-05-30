package view;

import controller.PlantEntryTableCntrl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PlantEntryTableUI extends JFrame {

    private JPanel tablePanel, buttonPanel;
    private JTable plantEntryTable;
    private JButton doneButton, detailsButton, newButton;
    private JScrollPane tableScroller;
    private PlantEntryTableCntrl plantEntryTableCntrl;


    public PlantEntryTableUI(PlantEntryTableCntrl plantEntryTableCntrl) {
        this.plantEntryTableCntrl = plantEntryTableCntrl;
        initComponents();
    }

    public void initComponents() {
        tablePanel = new JPanel();
        buttonPanel = new JPanel(new GridLayout(1, 4));
        plantEntryTable = new JTable(plantEntryTableCntrl.getThePlantEntryTableModel());
        plantEntryTable.getColumnModel().getColumn(0).setPreferredWidth(35);
        plantEntryTable.getColumnModel().getColumn(1).setPreferredWidth(35);
        plantEntryTable.getColumnModel().getColumn(2).setPreferredWidth(35);
        doneButton = new JButton("Done");
        detailsButton = new JButton("Show Details");
        newButton = new JButton("New");
        buttonPanel.add(newButton);
        buttonPanel.add(detailsButton);
        buttonPanel.add(doneButton);
        newButton.addActionListener(new NewButtonListener());
        detailsButton.addActionListener(new DetailsButtonListener());
        doneButton.addActionListener(new DoneButtonListener());
        tableScroller = new JScrollPane(plantEntryTable);
        plantEntryTable.setFillsViewportHeight(true);
        tableScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScroller.setPreferredSize(new Dimension(500, 400));
        tablePanel.add(tableScroller);
        this.setSize(700, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
    }

    public class DetailsButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedTableRow = plantEntryTable.getSelectedRow();
            int selectedModelRow = plantEntryTable.convertRowIndexToModel(selectedTableRow);
            if (selectedModelRow < 0) {
                selectedModelRow = 0;
            }
            plantEntryTableCntrl.showPlantEntryDetail(selectedModelRow);
        }


    }

    public class DoneButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public class NewButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            plantEntryTableCntrl.showNewPlantEntryDetail(plantEntryTableCntrl);

        }
    }
}
