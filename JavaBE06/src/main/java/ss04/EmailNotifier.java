package ss04;

public class EmailNotifier implements Notifier {
    public void sendNotification(String message, String recipient) {
        System.out.println("Email	to	" + recipient + ":	" + message);
    }
}
