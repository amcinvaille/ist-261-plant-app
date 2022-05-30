package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

//this class contains a LinkedList of available pots that can be added to and removed from
public class PotList {
    private LinkedList<Pot> availablePots = new LinkedList<Pot>();

    public PotList() {
        this.buildPotList();
        this.printPotList();
    }

//create test pot list
    public void buildPotList() {
        Pot pot1 = new Pot(5, "white", false);
        Pot pot2 = new Pot(16, "blue", true);
        Pot pot3 = new Pot(10, "terra cotta", true);
        Pot pot4 = new Pot(12, "white patterned", true);
        Pot pot5 = new Pot(8, "terra cotta", false);

        this.availablePots.add(new Pot(6, "clay", false));
        this.addPot(pot1);
        this.addPot(pot2);
        this.addPot(pot3);
        this.addPot(pot4);
        this.addPot(pot5);

    }

    public void addPot(Pot newPot) {
        boolean potAdded = false;
        boolean insertDecision = false;
        ListIterator<Pot> potIterator = availablePots.listIterator();
        while(potIterator.hasNext()){
            insertDecision = potIterator.next(). decideToInsert(newPot);
            if(insertDecision) {
                availablePots.add(potIterator.previousIndex(), newPot);
                potAdded = true;
                break;
            }
        }
        if(potAdded == false){
            availablePots.add(newPot);
        }

    }

    public void removePot(Pot pot) {
        availablePots.remove(pot);

    }

    public ArrayList<Pot> getPot(String searchTerm) {
        ArrayList<Pot> searchPots = new ArrayList<>();
        int ans = -1;
        for (int i =0; i < availablePots.size(); i++) {
            if (availablePots.get(i).getColor().contains(searchTerm)) {
                searchPots.add(availablePots.get(i));
            }
            else if (searchTerm.equalsIgnoreCase(String.valueOf(availablePots.get(i).getSizeDiameter()))) {
                searchPots.add(availablePots.get(i));
            }
        }
        for (int a = 0; a < searchPots.size(); a++) {
            System.out.println(searchPots.get(a).toString());
        }
        return searchPots;
    }

    public void printPotList() {
        ListIterator<Pot> potIterator = availablePots.listIterator();
        while (potIterator.hasNext()) {
            System.out.println(potIterator.next().toString());
        }
    }
}
