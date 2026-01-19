import java.util.Scanner;

public class Statue extends  Item{
    private int weight;
    private String color;

    public Statue() {
    }

    public Statue(String id, int value, String creator, int weight, String color) {
        super(id, value, creator);
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter weight(kg): ");
                weight = Integer.parseInt(scanner.nextLine());

                if (weight >= 0) {
                    break;
                }
                System.out.println("weight must be >= 0!");

            } catch (NumberFormatException e) {
                System.out.println("weight must be an integer!");
            }
        }

        while (true) {
            System.out.print("Enter color: ");
            color = scanner.nextLine();

            if (!color.isEmpty()) {
                break;
            }
            System.out.println("color must not be empty!");
        }
    }
@Override
    public String toString() {
        return "value: " + value + " creator: " + creator + " weight " + weight + " color: " + color;
    }
}
