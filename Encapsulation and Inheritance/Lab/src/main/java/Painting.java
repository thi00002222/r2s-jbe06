import java.util.Scanner;

public class Painting extends Item {
    private int height;
    private int width;
    private boolean isWaterColor;
    private boolean isFramed;

    public Painting() {
    }

    public Painting(String id, int value, String creator, int height, int width, boolean isWaterColor, boolean isFramed) {
        super(id, value, creator);
        this.height = height;
        this.width = width;
        this.isWaterColor = isWaterColor;
        this.isFramed = isFramed;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isWaterColor() {
        return isWaterColor;
    }

    public boolean isFramed() {
        return isFramed;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setWaterColor(boolean waterColor) {
        isWaterColor = waterColor;
    }

    public void setFramed(boolean framed) {
        isFramed = framed;
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
            try {
                System.out.print("Enter width(cm): ");
                width = Integer.parseInt(scanner.nextLine());

                if (width >= 0) {
                    break;
                }
                System.out.println("width must be >= 0!");

            } catch (NumberFormatException e) {
                System.out.println("width must be an integer!");
            }
        }

        while (true) {
            System.out.println("It is watercolor?(Y/N)");
            String text = scanner.nextLine().toLowerCase();
            if (text.contains("y")) {
                isWaterColor = true;
                break;
            } else if (text.contains("n")) {
                isWaterColor = false;
                break;
            }
            System.out.println("Please indicate whether the painting is a color water");
        }

        while (true) {
            System.out.println("It is framed?(Y/N)");
            String text = scanner.nextLine().toLowerCase();
            if (text.equals("y") || text.equals("yes")) {
                isFramed = true;
                break;
            } else if (text.equals("n") || text.equals("no")) {
                isFramed = false;
                break;
            }
            System.out.println("Please indicate whether the painting is a framed");
        }

    }
@Override
    public String toString() {
        return "value: " + value + " creator: " + creator + " height " + height + " width: " + width + " water color: " + (isWaterColor ? "Yes" : "No") + " framed: " + (isFramed ? "Yes" : "No");
    }
}
