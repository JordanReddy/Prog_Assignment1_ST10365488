/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorymanagementsystem;

public class InventoryItem {
    private int id;
    private String name;
    private int quantity;

    // Constructor to initialize an InventoryItem
    public InventoryItem(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setter method to update quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Placeholder for calculating the value of an item (override in subclasses)
    public double calculateValue() {
        return 0.0;
    }
}
