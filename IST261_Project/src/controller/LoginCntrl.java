package controller;

import model.*;
import view.*;

public class LoginCntrl {
    private LoginUI theLoginUI;
    private AccountList theAcctList;

    public LoginCntrl() {
        theLoginUI = new LoginUI(this);
        theAcctList = new AccountList();
        theAcctList.setAcctList(theAcctList.getListOfAccounts());
        showLoginUI();

    }

    public AccountList getAccountList() {
        return theAcctList;
    }

    public boolean requestAuthenticate(Account acct) {
        if (theAcctList.authenticate(acct) == true) {
            return true;
        } else {
            return false;
        }
    }

    public Account getCurrentUser() {
        return theAcctList.getCurrentAcct();
    }

    public void showLoginUI() {
        theLoginUI.setVisible(true);
    }

    public LoginUI getTheLoginUI() {
        return theLoginUI;
    }

}
