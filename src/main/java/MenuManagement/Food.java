/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuManagement;

public class Food {
    protected int id;
    public String name;
    public float price;
    public String preparationTime;
    public String ingredients;

    public Food(int id, String name, float price, String preparationTime, String ingredients) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.preparationTime = preparationTime;
        this.ingredients = ingredients;
    }

    public void getDetails() {
        System.out.println("Id          >> " + id);
        System.out.println("FoodName    >> " + name);
        System.out.println("PrepTime    >> " + preparationTime);
        System.out.println("Ingredients >> " + ingredients);
    }
}
