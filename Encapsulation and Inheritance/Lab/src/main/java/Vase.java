import java.util.Scanner;

public class Vase extends Item {
    private int height;
    private String material;

    public Vase() {
    }

    public Vase(String id, int value, String creator, int height, String material) {
        super(id, value, creator);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter height(cm): ");
                height = Integer.parseInt(scanner.nextLine());

                if (height >= 0) {
                    break;
                }
                System.out.println("height must be >= 0!");

            } catch (NumberFormatException e) {
                System.out.println("height must be an integer!");
            }
        }

        while (true) {
            System.out.print("Enter material: ");
            material = scanner.nextLine();

            if (!material.isEmpty()) {
                break;
            }
            System.out.println("material must not be empty!");
        }
    }

    public String toString() {
        return "value: " + value + " creator: " + creator + " height " + height + " material: " + material;
    }
}
