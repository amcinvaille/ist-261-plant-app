package model;

import java.io.*;
import java.util.ArrayList;

public class AccountList {
    private ArrayList<Account> acctList = new ArrayList<>();
    private PlantEntryList thePlantList = new PlantEntryList();
    private Account currentAcct;
    private String listOfAccountsFileName = "listOfAccounts.ser";
    private ArrayList<Account> listOfAccounts = new ArrayList<>();

    public AccountList() {
        this.readAccountListFile();
        if(listOfAccounts.isEmpty() || listOfAccounts == null){
            this.createTestAccountList();
            this.writeAccountListFile();
            this.readAccountListFile();
        }

    }

    public ArrayList<Account> getAcctList() {
        return acctList;
    }

    public void setAcctList(ArrayList<Account> acctList) {
        this.acctList = acctList;
    }

    public Account getCurrentAcct() {
        return currentAcct;
    }

    public void setCurrentAcct(Account currAcct) {
        this.currentAcct = currAcct;
    }

    public PlantEntryList getThePlantList() {
        return thePlantList;
    }

    public void setPlantEntryList(PlantEntryList plantList) {
        this.thePlantList = plantList;
    }

    public boolean authenticate(Account acct) {
        for (Account account : acctList) {
            if (acct.getUsername().equals(account.getUsername()) && acct.getPassword().equals(account.getPassword())) {
                this.currentAcct = account;
                return true;
            }
        }
        return false;
    }


    public void writeAccountListFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(listOfAccountsFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listOfAccounts);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createTestAccountList() {
        PlantEntryList thePlantList = new PlantEntryList();
        thePlantList.setPlantEntryList(thePlantList.getListOfPlants());
        Account acct1 = new Account("Alexa", "McInvaille", "am96", "pass123", "azm6551@psu.edu", thePlantList);
        Account acct2 = new Account("Elise", "McIntyre", "ekm", "pass123", "ekm@yahoo.com", thePlantList);
        Account acct3 = new Account("Halston", "McIntyre", "halM", "pass123", "hmm@gmail.com", thePlantList);
        listOfAccounts.add(acct1);
        listOfAccounts.add(acct2);
        listOfAccounts.add(acct3);
        System.out.println("Test AccountList created");
        System.out.println("The UserList is: " + listOfAccounts);
    }


    public void readAccountListFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(listOfAccountsFileName);
            in = new ObjectInputStream(fis);
            listOfAccounts = (ArrayList) in.readObject();
            in.close();
            if (!listOfAccounts.isEmpty()) {
                System.out.println("There are users in the user list");
            }
        } catch (FileNotFoundException fne) {
            System.out.println("File was not found, a new one will be created");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void printAccountList() {
        System.out.println("The AccountList has these users:");
        for (int i = 0; i < listOfAccounts.size(); i++) {
            Account currentAccount = (Account) listOfAccounts.get(i);
            System.out.println(currentAccount.getUsername());
        }
    }

    public String getListOfAccountsFileName() {
        return listOfAccountsFileName;
    }

    public void setListOfAccountsFileName(String listOfAccountsFileName) {
        this.listOfAccountsFileName = listOfAccountsFileName;
    }

    public ArrayList<Account> getListOfAccounts() {
        return listOfAccounts;
    }

    public void setListOfAccounts(ArrayList<Account> listOfAccounts) {
        this.listOfAccounts = listOfAccounts;
    }


}
