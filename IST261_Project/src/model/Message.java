package model;

//This class will contain all potential messages that users/accounts could receive
//Ex. welcome message, happy birthday message, plant tips/tricks, PlantApp anniversary, etc.

public class Message extends Notification {
    private String type;

    public Message(Account recipient, String subject, String message, String type) {
        super(recipient, subject, message);
        this.type = type;
    }

    public Message(Account recipient, String type) {
        super(recipient);
        this.type = type;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //Planning to add additional message types depending on circumstances
    //Will likely create different methods for each message that will be called depending on type
    //Will be a GUI element, so different effects can happen when different messages sent
    @Override
    public void sendNotification() {
        super.setSubject("Message");
        if (this.type.equalsIgnoreCase("welcome")) {
            super.setMessage("Welcome to PlantApp!");
        }
        System.out.println(super.getMessage());
    }
}
