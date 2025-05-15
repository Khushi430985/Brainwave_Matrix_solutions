import java.util.*;

public class Inventory {
    private static final List<Inventory> inventoryList = new ArrayList<>();

    private final String itemName;
    private int quantity;
    private final String expiryDate;
    private final String category;

    public Inventory(String itemName, int quantity, String expiryDate, String category) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public static void addItem() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("\n--- Add Inventory Item ---");
            System.out.print("Item Name: ");
            String name = sc.nextLine();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();  
            System.out.print("Expiry Date (DD-MM-YYYY): ");
            String expiry = sc.nextLine();
            System.out.print("Category (Medicine/Supply/Equipment): ");
            String category = sc.nextLine();

            inventoryList.add(new Inventory(name, quantity, expiry, category));
            System.out.println("Item added to inventory.");
        }
    }

    public static void viewItems() {
        System.out.println("\n--- Inventory Items ---");
        if (inventoryList.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Inventory i : inventoryList) {
                System.out.println("Name: " + i.itemName + ", Quantity: " + i.quantity +
                        ", Expiry: " + i.expiryDate + ", Category: " + i.category);
            }
        }
    }

    public static void updateItemQuantity() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Item Name to Update: ");
            String name = sc.nextLine();
            boolean found = false;

            for (Inventory i : inventoryList) {
                if (i.getItemName().equalsIgnoreCase(name)) {
                    System.out.print("New Quantity: ");
                    int newQty = sc.nextInt();
                    i.quantity = newQty;
                    System.out.println("Quantity updated.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Item not found.");
            }
        }
    }

    public static void removeItem() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Item Name to Remove: ");
            String name = sc.nextLine();
            boolean removed = inventoryList.removeIf(i -> i.getItemName().equalsIgnoreCase(name));

            if (removed) {
                System.out.println("Item removed from inventory.");
            } else {
                System.out.println("Item not found.");
            }
        }
    }

    public static void manageInventory() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n--- Inventory Management ---");
                System.out.println("1. Add New Item");
                System.out.println("2. View All Items");
                System.out.println("3. Update Item Quantity");
                System.out.println("4. Remove Item");
                System.out.println("5. Back to Main Menu");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> addItem();
                    case 2 -> viewItems();
                    case 3 -> updateItemQuantity();
                    case 4 -> removeItem();
                    case 5 -> {
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }
}
