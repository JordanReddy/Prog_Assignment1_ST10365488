/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorymanagementsystem;

public class Product extends InventoryItem {
    private double price;

    // Constructor to initialize a Product
    public Product(int id, String name, int quantity, double price) {
        super(id, name, quantity);
        this.price = price;
    }

    // Getter method for price
    public double getPrice() {
        return price;
    }

    // Override the calculateValue method to calculate the value of a Product
    @Override
    public double calculateValue() {
        return getPrice() * getQuantity();
    }
}

