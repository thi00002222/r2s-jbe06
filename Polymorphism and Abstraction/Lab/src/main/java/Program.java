import java.util.Scanner;

public class Program {
    private Product[] products;
    private byte numOfProduct;
    private final byte MAX = 100;


    public boolean isIdExists(int id) {
        for (int i = 0; i < numOfProduct; i++) {
            if (products[i].getId() == id) {
                return true;
            }
        }
        return false;
    }


    public Program() {
        products = new Product[MAX];
    }

    public void addProduct(Product product) {
        if (numOfProduct < MAX) {
            products[numOfProduct++] = product;
        } else {
            System.out.println("Product list is full!");
        }
        System.out.println("Added!");
    }

    public static void addProductMenu(Program program, Scanner sc) {
        System.out.println("\n--- Add Product ---");
        System.out.println("1. Electronics");
        System.out.println("2. Clothing");
        System.out.print("Choose product type: ");

        byte type = Byte.parseByte(sc.nextLine());
        Product p;

        if (type == 1) {
            p = new Electronics();
        } else if (type == 2) {
            p = new Clothing();

        } else {
            System.out.println("Invalid product type!");
            return;
        }

        byte id;
        do {
            System.out.print("Enter ID: ");
            id = Byte.parseByte(sc.nextLine());

            if (program.isIdExists(id)) {
                System.out.println("ID already exists! Please enter again.");
            }
        } while (program.isIdExists(id));
        p.setId(id);
        p.input(sc);
        program.addProduct(p);
    }

    public void displayProducts() {
        if (numOfProduct == 0) {
            System.out.println("No products available.");
            return;
        }
        for (int i = 0; i < numOfProduct; i++) {
            System.out.println(products[i].toString());
        }

    }

    public Product findProduct(byte i) {
        for (int j = 0; j < numOfProduct; j++) {
            if (products[j].getId() == i) {
                return products[j];
            }
        }
        return null;
    }

    public void updateProduct(byte id, Scanner scanner) {
        Product updID = findProduct(id);
        if (updID != null) {
            updID.update(scanner);
        }
    }


    public static void main(String[] args) {
        Program program = new Program();
        Scanner sc = new Scanner(System.in);

        int choice = 0;

        do {
            try {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Add Product");
                System.out.println("2. Display Products");
                System.out.println("3. Find Product");
                System.out.println("4. Update Product");
                System.out.println("0. Exit");
                System.out.print("Choose: ");

                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addProductMenu(program, sc);
                        break;

                    case 2:
                        program.displayProducts();
                        break;

                    case 3:
                        System.out.print("Enter product ID to find: ");
                        byte id = Byte.parseByte(sc.nextLine());
                        Product p = program.findProduct(id);
                        if (p != null) {
                            System.out.println(p.toString());
                        } else {
                            System.out.println("Product not found!");
                        }
                        break;
                    case 4:
                        System.out.print("Enter product ID to update: ");
                        byte uid = Byte.parseByte(sc.nextLine());
                        program.updateProduct(uid,sc);
                        break;
                    case 0:
                        System.out.println("Exit program.");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("please enter 1 to 3 or 0");
            }
        } while (true);
    }


}

