/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuManagement;

import java.util.ArrayList;

/**
 *
 * @author X1
 */
abstract public class Menu {
    private int id;
    private String name;
    private float price;
    private String description;
    private int stock;
    

    public Menu(String name, float price, String description, int stock) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }
    abstract public void getDetails();
    public void updateStock(int stock) {
        this.stock = stock;
    }
}
