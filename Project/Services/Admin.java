package Services;

import java.util.*;

class FoodItem {
    private int id;
    private String name;
    private double price;
    private String description;
    private boolean available;

    public FoodItem(int id, String name, double price, String description, boolean available) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.available = available;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public boolean isAvailable() { return available; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return "ID: " + id + ", " + name + " - $" + price +
                "\n   " + description + " | Available: " + (available ? "Yes" : "No");
    }
}

public class Admin {
    private static Map<Integer, FoodItem> menu = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    private static int nextId = 1;

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. Add New Food Item");
            System.out.println("2. Update Food Item");
            System.out.println("3. Delete Food Item");
            System.out.println("4. View Menu");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addFoodItem();
                    break;
                case 2:
                    updateFoodItem();
                    break;
                case 3:
                    deleteFoodItem();
                    break;
                case 4:
                    viewMenu();
                    break;
                case 0:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    // Add new FoodItem
    private static void addFoodItem() {
        System.out.print("Enter Food Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Description: ");
        String desc = sc.nextLine();
        System.out.print("Is Available? (true/false): ");
        boolean available = sc.nextBoolean();

        FoodItem item = new FoodItem(nextId++, name, price, desc, available);
        menu.put(item.getId(), item);
        System.out.println(" Food item added successfully!");
    }

    // Update FoodItem
    private static void updateFoodItem() {
        System.out.print("Enter Food ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!menu.containsKey(id)) {
            System.out.println(" Item not found!");
            return;
        }

        FoodItem item = menu.get(id);
        System.out.print("Enter new name (" + item.getName() + "): ");
        String name = sc.nextLine();
        System.out.print("Enter new price (" + item.getPrice() + "): ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter new description (" + item.getDescription() + "): ");
        String desc = sc.nextLine();
        System.out.print("Available? (true/false): ");
        boolean available = sc.nextBoolean();

        item.setName(name);
        item.setPrice(price);
        item.setDescription(desc);
        item.setAvailable(available);
        System.out.println(" Food item updated successfully!");
    }

    // Delete FoodItem
    private static void deleteFoodItem() {
        System.out.print("Enter Food ID to delete: ");
        int id = sc.nextInt();

        if (menu.remove(id) != null) {
            System.out.println("Food item deleted successfully!");
        } else {
            System.out.println("Item not found!");
        }
    }

    // View Menu
    private static void viewMenu() {
        System.out.println("\n==== CURRENT MENU ====");
        if (menu.isEmpty()) {
            System.out.println("No food items available.");
        } else {
            for (FoodItem item : menu.values()) {
                System.out.println(item);
            }
        }
    }
}


