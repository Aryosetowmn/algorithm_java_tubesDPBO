/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuManagement;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class MenuManagement {
    private ArrayList<Food> menu;

    public MenuManagement() {
        this.menu = new ArrayList<>();
    }

    public void updateStock(int foodId, int newStock) {
        if (foodId > 0 && foodId <= menu.size()) {
            Food food = menu.get(foodId - 1);
            food.price = newStock;
            System.out.println("Stock updated successfully!");
        } else {
            System.out.println("Invalid FoodId!");
        }
    }

    public void getDetails() {
        for (Food food : menu) {
            food.getDetails();
        }
    }
}
