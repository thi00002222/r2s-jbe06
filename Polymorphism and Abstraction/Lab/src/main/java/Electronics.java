import java.util.Scanner;

public class Electronics extends Product {
    private String brand;

    public Electronics(int id, String name, float price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    public Electronics() {
        super();
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        System.out.print("Enter brand: ");
        brand = sc.nextLine();
    }

    @Override
    public void update(Scanner scanner) {
        System.out.print("Enter new name: ");
        name = scanner.nextLine();

        System.out.print("Enter new price: ");
        price = Float.parseFloat(scanner.nextLine());

        System.out.print("Enter new brand: ");
        brand = scanner.nextLine();
    }

    @Override
    public String toString() {
        return super.toString() + "Brand: " + brand;
    }
}
