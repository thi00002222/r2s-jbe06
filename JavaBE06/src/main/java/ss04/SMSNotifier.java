package ss04;

public class SMSNotifier implements Notifier {
    public void sendNotification(String message, String recipient) {
        System.out.println("SMS	to	" + recipient + ":	" + message);
    }
}
