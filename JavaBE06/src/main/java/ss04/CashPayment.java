package ss04;

public class CashPayment implements PaymentStrategy{

    @Override
    public void pay(int amount) {
        System.out.println("Paid: " + amount);
    }
}
