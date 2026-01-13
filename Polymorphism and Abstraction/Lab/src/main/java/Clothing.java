import java.util.Scanner;

public class Clothing extends Product {
    private String size;

    public Clothing(int id, String name, float price, String size) {
        super(id, name, price);
        this.size = size;
    }

    public Clothing() {
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        System.out.print("Enter size: ");
        size = sc.nextLine();
    }

    @Override
    public void update(Scanner scanner) {
        System.out.print("Enter new name: ");
        name = scanner.nextLine();

        System.out.print("Enter new price: ");
        price = Float.parseFloat(scanner.nextLine());

        System.out.print("Enter new size: ");
        size = scanner.nextLine();
    }
    @Override
    public String toString(){
        return super.toString() + "Size: "+size;
    }
}
