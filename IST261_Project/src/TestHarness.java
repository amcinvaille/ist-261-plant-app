import model.*;

import java.util.ArrayList;

public class TestHarness {

    public TestHarness() {
        //testPlantClass();
        //testNotificationClass();
        //testClassHierarchy();
        //testInterface();
    }

    public void testPlantClass() {
        System.out.println("Testing the Plant class");
        Plant plant = new Plant();
        if (plant != null) {
            System.out.println(plant.getPlantType());
            System.out.println(plant.getPlantDescription());
        } else {
            System.out.println("There was an error creating the plant");
        }

        plant.setPlantType("Pothos");
        plant.setPlantDescription("Green leafy plant");

        System.out.println(plant.toString());

    }

    public void testNotificationClass() {
        System.out.println("Testing the Notification class");
        Account acct = new Account();
        Notification notification = new Notification(acct, "first message", "hello");
        if (notification != null) {
            System.out.println(notification.getRecipient());
            System.out.println(notification.getSubject());
            System.out.println(notification.getMessage());
        } else {
            System.out.println("There was an error creating the notification");
        }

        notification.setRecipient(new Account("Alexa", "McInvaille", "am96", "testPass", "email@email.com"));
        notification.setSubject("testing");
        notification.setMessage("this is for testing");
        notification.setMessage("test notification");

        System.out.println(notification.toString());
    }

    public void testClassHierarchy() {
        System.out.println("Testing Class Hierarchy");
        ArrayList<Notification> testing = new ArrayList<>();
        Account acct = new Account();
        Plant plant = new Plant();
        PlantEntry plant1 = new PlantEntry(plant);
        plant1.setPlantName("Test Plant");
        Message msg = new Message(acct, "welcome");
        CareReminder reminder = new CareReminder(acct, 7, "water", plant1);
        testing.add(msg);
        testing.add(reminder);

        for (int i = 0; i < testing.size(); i++) {
            testing.get(i).sendNotification();
        }
    }

    public void testInterface() {
        ArrayList<careInstructions> careList = new ArrayList<>();
        Plant plant = new Plant("succulent", "Aloe Vera");
        HerbPlant herb = new HerbPlant("herb", "Basil");
        careList.add(plant);
        careList.add(herb);

        for (int i = 0; i < careList.size(); i++) {
            careList.get(i).displayIdealLight();
            careList.get(i).displayIdealSoil();
            careList.get(i).displayWaterInstructions();
        }


    }
}
