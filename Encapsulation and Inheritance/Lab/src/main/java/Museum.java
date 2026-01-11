import java.util.Scanner;

public class Museum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ItemList itemList = new ItemList();
        byte choice = 0;
        do {
            try {

            System.out.println("1. Add a new Vase");
            System.out.println("2. Add a new Statue");
            System.out.println("3. Add a new Painting");
            System.out.println("4. Display all items");
            System.out.println("5. Find the items by the creator");
            System.out.println("6. Display the list of type items");
            System.out.println("7. Quit");
            System.out.print("Your choice: ");
            System.out.println();
            choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
                    Vase vase = new Vase();
                    vase.input();

                    System.out.println("added");
                    itemList.addItem(vase);
                    break;
                case 2:
                    Statue statue = new Statue();
                    statue.input();

                    System.out.println("added");
                    itemList.addItem(statue);
                    break;
                case 3:
                    Painting painting = new Painting();
                    painting.input();

                    System.out.println("added");
                    itemList.addItem(painting);
                    break;
                case 4:
                    itemList.displayAll();
                    break;
                case 5:
                    System.out.print("Enter creator you want to find:");
                    String creator = scanner.nextLine();

                    itemList.findItem(creator);
                    itemList.showItemByCreator(creator);

                    break;
                case 6:
                    System.out.print("Enter type you want to find:");
                    String type = scanner.nextLine();

                    itemList.displayItemsByType(type);
                    break;
                case 7:
                    System.out.println("Please press ENTER again to exit");
                    String confirm = scanner.nextLine();

                    if (confirm.isEmpty()){
                        return;
                    }
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

            } catch (NumberFormatException e){
                System.out.println("please enter 1 to 7");
            }

        } while (true);

    }
}
