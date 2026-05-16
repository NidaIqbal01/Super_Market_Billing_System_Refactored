/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermarket;

public class CartItemWrapper implements Cartable {
    private final String name;
    private final double price;
    private int quantity;

    public CartItemWrapper(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public void displayInfo() {
        System.out.println("\t\t" + name + " - " + quantity + " x $" + price + " = $" + (price * quantity));
    }
}
