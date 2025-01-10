/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuManagement;

import java.util.ArrayList;

public class MenuManagement {
    protected int id;
    protected String name;
    protected float price;
    protected int stock;
    public MenuManagement(int id, float price, int stock) {
        this.id = id;
        this.price = price;
        this.stock = stock;
    }
    
    public void updateStock(int foodId, int newStock, ArrayList<MenuManagement> menu) {
        if (foodId > 0 && foodId <= menu.size()) {
            MenuManagement menus = menu.get(foodId - 1);
            menus.stock = stock - newStock;
            System.out.println("Stock updated successfully!");
        } else {
            System.out.println("Invalid FoodId!");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
