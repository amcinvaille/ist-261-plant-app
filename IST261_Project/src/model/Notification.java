package model;

public class Notification {
    private Account recipient;
    private String subject;
    private String message;
    //private String type; //CareReminder, alert, message


    public Notification(Account recipient, String subject, String message) {
        this.recipient = recipient;
        this.subject = subject;
        this.message = message;
    }

    public Notification(Account recipient) {
        this.recipient = recipient;
    }

    public Account getRecipient() {
        return recipient;
    }

    public void setRecipient(Account recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "Recipient: " + recipient + "\nSubject: " + subject + "\nMessage: " + message;

    }

    //This method will work use GUI to display the notification to an account
    public void sendNotification() {
        String greeting = "Hello " + this.recipient.getFirstName() + "! You have a " + this.subject + ": \n";
        String notification = greeting + this.message;
        System.out.println(notification);

    }
}
