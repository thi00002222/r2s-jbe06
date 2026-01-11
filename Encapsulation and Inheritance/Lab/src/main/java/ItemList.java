
public class ItemList {
    private Item[] list;
    private int numOfItem;
    private final int MAX = 100;

    public ItemList() {
        list = new Item[MAX];
    }

    public boolean addItem(Item item) {
        if (item == null) {
            System.out.println("Item is null");
            return false;
        }
        if (numOfItem >= MAX) {
            System.out.println("List is full");
            return false;
        }
        list[numOfItem++] = item;
        return true;
    }

    public void displayAll() {
        if (numOfItem <= 0) {
            System.out.println("The list is empty!");
            return;
        }
        for (int i = 0; i < numOfItem; i++) {
            System.out.println((i + 1) + " " + list[i]);
        }
    }

    public Item findItem(String creator) {
        for (int i = 0; i < numOfItem; i++) {
            if (list[i].getCreator().equalsIgnoreCase(creator.trim())) {
                return list[i];
            }
        }
        return null;
    }

    public void displayItemsByType(String type) {
        if (type == null || type.trim().isEmpty()) {
            System.out.println("Type is null!!");
            return;
        }

        type = type.toLowerCase();
        for (int i = 0; i < numOfItem; i++) {
            switch (type) {
                case "vase":
                    if (list[i] instanceof Vase) {
                        System.out.println(list[i]);
                    }
                    break;
                case "statue":
                    if (list[i] instanceof Statue) {
                        System.out.println(list[i]);
                    }
                    break;
                case "painting":
                    if (list[i] instanceof Painting) {
                        System.out.println(list[i]);
                    }
                    break;
                default:
                    System.out.println("Unknow the type your enter " + type);
                    return;
            }
        }
    }

    public void showItemByCreator(String creator) {
        for (int i = 0; i < numOfItem; i++) {
            if (list[i].getCreator().equalsIgnoreCase(creator)) {
                System.out.println((i + 1) + " " + list[i]);
            } else {
                System.out.println("not find the creator");
            }
        }
    }
}
