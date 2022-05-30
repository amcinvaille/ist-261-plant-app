package model;

public class HerbPlant extends Plant implements careInstructions {

    private String harvestDate;

    public HerbPlant(String type, String description, String harvestDate) {
        super(type, description);
        this.harvestDate = harvestDate;

    }

    public HerbPlant(String type, String description) {
        super(type, description);
    }

    public String getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(String harvestDate) {
        this.harvestDate = harvestDate;
    }

    @Override
    public void displayWaterInstructions() {
        System.out.println("Keep soil consistently moist. Be careful not to overwater.");
    }

    @Override
    public void displayIdealLight() {
        System.out.println("Most herbs prefer lots of sunlight.");
    }

    @Override
    public void displayIdealSoil() {
        System.out.println("Herbs require soil with excellent drainage. Use indoor potting soil. ");
    }
}
