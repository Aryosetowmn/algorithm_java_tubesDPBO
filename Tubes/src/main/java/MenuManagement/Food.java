/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuManagement;

import java.util.ArrayList;

public class Food extends MenuManagement {
    protected String preparationTime;
    protected String[] ingredients;

    public Food(int id, String name, float price, String preparationTime, String[] ingredients, int stock) {
        super(id, price, stock);
        this.name = name;
        this.preparationTime = preparationTime;
        this.ingredients = ingredients;
    }

    public void getDetails() {
        System.out.println("Id          >> " + id);
        System.out.println("FoodName    >> " + name);
        System.out.println("Price    >> " + price);
        System.out.println("Stock    >> " + stock);
        System.out.println("PrepTime    >> " + preparationTime);
        System.out.println("Ingredients >> " + String.join(", ", ingredients));
    }

    public boolean checkIngredient(String ingredient) {
        for (String ing : ingredients) {
            if (ing.equalsIgnoreCase(ingredient)) {
                return true;
            }
        }
        return false;
    }

    public static Food searchFoodByIngredient(ArrayList<Food> menu, String ingredient) {
        for (Food food : menu) {
            if (food.checkIngredient(ingredient)) {
                return food;
            }
        }
        return null;
    }

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }
    
    
}
