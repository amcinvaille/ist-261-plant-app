package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private PlantEntryList plantEntries;
    private ArrayList<Location> locations;

    //Constructor
    public Account(String firstName, String lastName, String username, String password, String email, PlantEntryList plantEntries, ArrayList<Location> locations) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.plantEntries = plantEntries;
        this.locations = locations;

    }

    public Account(String firstName, String lastName, String username, String password, String email, PlantEntryList plantEntries) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.plantEntries = plantEntries;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }



    public Account(String firstName, String lastName, String username, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Account() {
        this.firstName = "firstName";
        this.lastName = "lastName";
        this.username = "username";
        this.password = "password";
        this.email = "email";
    }

    //Getters & Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PlantEntryList getPlantEntries() {
        return plantEntries;
    }

    public void setPlantEntries(PlantEntryList plantEntries) {
        this.plantEntries = plantEntries;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return ("Name: " + firstName + " " + lastName + "\nUsername: " + username + "\nPassword: " + password + "\nEmail: " + email);
    }
}
