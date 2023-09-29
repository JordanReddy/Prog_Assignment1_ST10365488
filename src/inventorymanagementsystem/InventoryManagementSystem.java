/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inventorymanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagementSystem {
    private static ArrayList<InventoryItem> inventory = new ArrayList<>();
    private static int nextItemId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu options
            System.out.println("Inventory Management System");
            System.out.println("1. Add new item");
            System.out.println("2. Update item quantity");
            System.out.println("3. Display inventory");
            System.out.println("4. Calculate total value");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addItem(scanner); // Call method to add a new item
                    break;
                case 2:
                    updateItemQuantity(scanner); // Call method to update item quantity
                    break;
                case 3:
                    displayInventory(); // Call method to display the inventory
                    break;
                case 4:
                    calculateTotalValue(); // Call method to calculate total inventory value
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0); // Exit the program
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addItem(Scanner scanner) {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter item type (1 for Product, 2 for Service): ");
        int itemType = scanner.nextInt();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        if (itemType == 1) {
            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            inventory.add(new Product(nextItemId++, name, quantity, price)); // Add a new product
        } else if (itemType == 2) {
            inventory.add(new Service(nextItemId++, name, quantity)); // Add a new service
        } else {
            System.out.println("Invalid item type.");
        }
    }

    private static void updateItemQuantity(Scanner scanner) {
        System.out.print("Enter item ID: ");
        int itemId = scanner.nextInt();

        InventoryItem item = findItemById(itemId);
        if (item != null) {
            System.out.print("Enter new quantity: ");
            int newQuantity = scanner.nextInt();
            item.setQuantity(newQuantity); // Update item quantity
            System.out.println("Quantity updated successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }

    private static InventoryItem findItemById(int itemId) {
        for (InventoryItem item : inventory) {
            if (item.getId() == itemId) {
                return item; // Find and return an item by ID
            }
        }
        return null;
    }

    private static void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory:");
            for (InventoryItem item : inventory) {
                // Display item details
                System.out.println("ID: " + item.getId() + ", Name: " + item.getName() + ", Quantity: " + item.getQuantity());
            }
        }
    }

    private static void calculateTotalValue() {
        double totalValue = 0.0;
        for (InventoryItem item : inventory) {
            totalValue += item.calculateValue(); // Calculate the total inventory value
        }
        System.out.println("Total inventory value: $" + totalValue);
    }
}
