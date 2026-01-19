import java.util.Scanner;

public class Item {
    protected String id;
    protected int value;
    protected String creator;

    public String getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public String getCreator() {
        return creator;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Item() {
    }

    public Item(String id, int value, String creator) {
        this.id = id;
        this.value = value;
        this.creator = creator;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter ID: ");
            id = scanner.nextLine();
            if (!id.isEmpty()) {
                break;
            }
            System.out.println("ID must not be empty!");
        }

        while (true) {
            try {
                System.out.print("Enter value(USD): ");
                value = Integer.parseInt(scanner.nextLine());
                if (value >= 0) {
                    break;
                }
                System.out.println("Value must be >= 0!");
            } catch (NumberFormatException e) {
                System.out.println("Value must be an integer!");
            }
        }

        while (true) {
            System.out.print("Enter creator: ");
            creator = scanner.nextLine();
            if (!creator.isEmpty()) {
                break;
            }
            System.out.println("Creator is not null");
        }
//
    }
@Override
    public String toString() {
        return id + " " + creator + " " + value;
    }
}
