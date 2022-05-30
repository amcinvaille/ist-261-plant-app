package controller;

import model.*;
import view.PlantEntryUI;

public class PlantEntryCntrl {
    private PlantEntryUI thePlantEntryUI;
    private PlantEntryList thePlantEntryList;
    private PlantSetCntrl thePlantSetCntrl = new PlantSetCntrl();
    private PlantEntryTableCntrl thePlantEntryTableCntrl;
    private AccountList theAcctList;
    private Account currAcct;
    private int row = 0;

    public PlantEntryCntrl(PlantEntryTableCntrl plantEntryTableCntrl) {
        this.thePlantEntryTableCntrl = plantEntryTableCntrl;
        thePlantEntryList = thePlantEntryTableCntrl.getThePlantEntryList();
        thePlantEntryUI = new PlantEntryUI(this, row);

        showPlantEntryUI(row);
    }

    public PlantEntryCntrl(PlantEntryTableCntrl plantEntryTableCntrl, int row) {
        this.thePlantEntryTableCntrl = plantEntryTableCntrl;
        thePlantEntryList = plantEntryTableCntrl.getThePlantEntryList();
        thePlantEntryUI = new PlantEntryUI(this, row);

        showPlantEntryUI(row);
    }

    public void showPlantEntryUI(int row) {
        thePlantEntryUI = new PlantEntryUI(this, row);
        thePlantEntryUI.setVisible(true);
    }

    public void showPlantEntryTable() {
        thePlantEntryUI.dispose();
        thePlantEntryTableCntrl.showPlantEntryTable(thePlantEntryTableCntrl.getCurrentAcct());
    }

    public PlantEntryUI getThePlantEntryUI() {
        return thePlantEntryUI;
    }

    public void setThePlantEntryUI(PlantEntryUI plantUI) {
        this.thePlantEntryUI = plantUI;
    }

    public PlantEntryList getThePlantEntryList() {
        return thePlantEntryList;
    }

    public void setThePlantEntryList(PlantEntryList plantList) {
        this.thePlantEntryList = plantList;
    }

    public PlantEntryTableCntrl getThePlantEntryTableCntrl() {
        return thePlantEntryTableCntrl;
    }

    public void setThePlantEntryTableCntrl(PlantEntryTableCntrl plantEntryTableCntrl) {
        this.thePlantEntryTableCntrl = plantEntryTableCntrl;
    }

    public PlantSetCntrl getThePlantSetCntrl() {
        return thePlantSetCntrl;
    }

    public void setThePlantSetCntrl(PlantSetCntrl thePlantSetCntrl) {
        this.thePlantSetCntrl = thePlantSetCntrl;
    }

    public void addNewPlantEntry(PlantEntry plantEntry) {
        thePlantEntryList.getPlantEntryList().add(plantEntry);
        thePlantEntryList.writePlantListFile();
        //need to write to AccountList file too to see if it will save with the account...
        theAcctList.writeAccountListFile();

    }

    public void deletePlant(int plant) {
        this.thePlantEntryList.getPlantEntryList().remove(plant);
        thePlantEntryList.writePlantListFile();
        //need to write to AccountListFile too to see if it will save with the account...
        theAcctList.writeAccountListFile();

    }

    public void setCurrAcct(Account currentAcct) {
        this.currAcct = currentAcct;
    }

    public Account getCurrAcct() {
        return currAcct;
    }

    public void setTheAcctList(AccountList acctList) { this.theAcctList = acctList; }

    public AccountList getTheAcctList() {
        return theAcctList;
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int i) {
        this.row = i;
    }

}
