package ss04;

public class HrApp {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        HrSystem hr = new HrSystem(notifier);
        hr.notifyEmployee("Your	leave	request	is	approved.", "employee@company.com");
    }
}
