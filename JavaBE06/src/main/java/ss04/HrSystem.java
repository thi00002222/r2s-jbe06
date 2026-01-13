package ss04;

public class HrSystem {
    private Notifier notifier;

    public HrSystem(Notifier notifier) {
        this.notifier = notifier;
    }

    public void notifyEmployee(String message, String recipient) {
        notifier.sendNotification(message, recipient);
    }
}
