package model;

public class Pot {
    private int sizeDiameter;
    private String color;
    private boolean drainageHole;

    public Pot(int size, String color, boolean drainageHole) {
        this.sizeDiameter = size;
        this.color = color;
        this.drainageHole = drainageHole;
    }

    public int getSizeDiameter() {
        return sizeDiameter;
    }

    public void setSizeDiameter(int sizeDiameter) {
        this.sizeDiameter = sizeDiameter;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isDrainageHole() {
        return drainageHole;
    }

    public void setDrainageHole(boolean drainageHole) {
        this.drainageHole = drainageHole;
    }

    public String toString() {
        return "Pot size: " + sizeDiameter + " - Color: " + color + " - Drainage hole: " + drainageHole;
    }

    public boolean decideToInsert(Pot newPot) {
        boolean decision = false;

        if (newPot.sizeDiameter >= this.sizeDiameter) {
            decision = true;
        }
        else {
            decision = false;
        }
        return decision;
    }
}
