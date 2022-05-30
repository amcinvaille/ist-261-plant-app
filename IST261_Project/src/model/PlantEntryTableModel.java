package model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class PlantEntryTableModel extends AbstractTableModel {

    private String[] columnNames = {"Plant Name", "Type", "Date Potted"};
    private ArrayList<PlantEntry> plantEntryList;

    public PlantEntryTableModel(ArrayList<PlantEntry> newPlantEntryList) {

        plantEntryList = newPlantEntryList;
    }


    @Override
    public int getRowCount() {
        return plantEntryList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return (Object) plantEntryList.get(rowIndex).getPlantName();
            case 1:
                return (Object) plantEntryList.get(rowIndex).getEntryPlant().getPlantType();
            case 2:
                return (Object) plantEntryList.get(rowIndex).getDatePotted();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
}
