package model;

public class CareReminder extends Notification {
    private int frequencyDays;
    private String type;
    private PlantEntry plant;


    public CareReminder(Account recipient, String subject, String message, int frequency, String type, PlantEntry plant) {
        super(recipient, subject, message);
        this.frequencyDays = frequency;
        this.type = type;
        this.plant = plant;

    }

    public CareReminder(Account recipient, int frequency, String type, PlantEntry plant) {
        super(recipient);
        this.frequencyDays = frequency;
        this.type = type;
        this.plant = plant;
    }

    public int getFrequencyDays() {
        return frequencyDays;
    }

    public void setFrequencyDays(int frequencyDays) {
        this.frequencyDays = frequencyDays;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //This method will be a GUI element
    @Override
    public void sendNotification() {
        super.setSubject("Reminder!");

        if (this.type.equals("water")) {
            super.setMessage("Have you watered " + this.plant.getPlantName() + " today?");
        } else if (this.type.equals("fertilize")) {
            super.setMessage(this.plant.getPlantName() + " would like some fertilizer today.");
        } else if (this.type.equals("repot")) {
            super.setMessage(this.plant.getPlantName() + " is due to be repotted.");
        }
        System.out.println(super.getSubject());
        System.out.println(super.getMessage());
    }
}
