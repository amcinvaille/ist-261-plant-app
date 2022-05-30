package controller;

import model.Account;
import model.PlantEntryList;
import model.PlantEntryTableModel;
import view.PlantEntryTableUI;

public class PlantEntryTableCntrl {

    private PlantEntryTableModel thePlantEntryTableModel;
    private PlantEntryList thePlantEntryList;
    private PlantEntryTableUI plantEntryTableUI;
    private PlantEntryCntrl plantEntryCntrl;
    private Account currentAcct;
    private LoginCntrl theLoginCntrl;

    public PlantEntryTableCntrl() {

    }


    public void showPlantEntryDetail(int row) {
        plantEntryTableUI.dispose();
        plantEntryCntrl = new PlantEntryCntrl(this, row);
        plantEntryCntrl.setTheAcctList(theLoginCntrl.getAccountList());
    }

    public void showPlantEntryTable(Account currAcct) {
        this.setCurrentAcct(currAcct);
        this.setThePlantEntryList(currAcct.getPlantEntries());
        thePlantEntryTableModel = new PlantEntryTableModel(thePlantEntryList.getPlantEntryList());
        plantEntryTableUI = new PlantEntryTableUI(this);
        plantEntryTableUI.setVisible(true);

        if (this.plantEntryCntrl != null) {
            this.plantEntryCntrl.getThePlantEntryUI().dispose();
        }
        //thePlantEntryTableCntrl.getThePlantEntryUI().setPlantEntry();
        //thePlantEntryTableCntrl.getThePlantEntryUI().setUpComboBox();
    }

    public void showNewPlantEntryDetail(PlantEntryTableCntrl plantEntryTableCntrl) {
        plantEntryTableUI.setVisible(false);
        plantEntryCntrl = new PlantEntryCntrl(plantEntryTableCntrl);
        plantEntryCntrl.getThePlantEntryUI().newPlantWindow();
        plantEntryCntrl.getThePlantEntryUI().setChangeInd("add");
        plantEntryCntrl.setTheAcctList(theLoginCntrl.getAccountList());
    }

    public PlantEntryTableModel getThePlantEntryTableModel() {
        return thePlantEntryTableModel;
    }

    public void setThePlantEntryTableModel(PlantEntryTableModel thePlantEntryTableModel) {
        this.thePlantEntryTableModel = thePlantEntryTableModel;
    }

    public PlantEntryList getThePlantEntryList() {
        return thePlantEntryList;
    }

    public void setThePlantEntryList(PlantEntryList thePlantEntryList) {
        this.thePlantEntryList = thePlantEntryList;
    }

    public Account getCurrentAcct() {
        return currentAcct;
    }

    public void setCurrentAcct(Account acct) {
        this.currentAcct = acct;
    }

    public LoginCntrl getTheLoginCntrl() {
        return theLoginCntrl;
    }

    public void setTheLoginCntrl(LoginCntrl loginCntrl) {
        this.theLoginCntrl = loginCntrl;
    }
}
