package view;

import javax.swing.*;

import controller.*;
import model.Account;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {
    private LoginCntrl theLoginCntrl;
    private JPanel loginPanel;
    private JLabel titleLabel;
    private JTextField userText;
    private JTextField pwdText;
    private JLabel userLabel;
    private JLabel pwdLabel;
    private JButton loginBtn;
    private JButton createAcctBtn;

    private PlantEntryTableCntrl thePlantEntryTableCntrl;

    public LoginUI(LoginCntrl loginCntrl) {
        this.theLoginCntrl = loginCntrl;
        this.add(loginPanel);
        this.setSize(400, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account acct = new Account("", "", userText.getText(), pwdText.getText(), "");
                if (theLoginCntrl.requestAuthenticate(acct) == true) {
                    thePlantEntryTableCntrl = new PlantEntryTableCntrl();
                    thePlantEntryTableCntrl.showPlantEntryTable(theLoginCntrl.getCurrentUser());
                    thePlantEntryTableCntrl.setTheLoginCntrl(theLoginCntrl);
                    theLoginCntrl.getTheLoginUI().setVisible(false);
                } else {
                    System.out.println("Incorrect username or password");
                }
            }
        });
        createAcctBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //will open the createAccountUI screen
            }
        });
    }
}
