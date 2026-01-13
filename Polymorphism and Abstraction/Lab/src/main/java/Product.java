import java.util.Scanner;

public abstract class Product {
    protected int id;
    protected String name;
    protected float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public void input(Scanner sc) {
        while (true) {
            System.out.print("Enter name: ");
            name = sc.nextLine();
            if (!name.isEmpty()) {
                break;
            }
            System.out.println("name is not null!");
        }

        while (true) {
            System.out.print("Enter price: ");
            price = Float.parseFloat(sc.nextLine());
            if (price > 0) {
                break;
            }
            System.out.println("price must be more than 0");
        }

    }

    @Override
    public String toString() {
        return "Id: " + id + " -name: " + name + " -price: " + price;
    }

    public abstract void update(Scanner sc);

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }


}
