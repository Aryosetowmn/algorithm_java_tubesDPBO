/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserManagement;

import MenuManagement.Food;
import OrderManagement.Order;
import java.util.ArrayList;
import java.util.Scanner;


public class Seller extends User{
    private String storeName;
    private float rating;

    public Seller(int id, String name, String email, String phone, String storeName, float rating) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.storeName = storeName;
        this.rating = rating;
    }

    public void manageMenu(ArrayList<Food> menu) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("==== Opsi Menu ====");
            System.out.println("1. Create Food");
            System.out.println("2. Show Food");
            System.out.println("3. Update Food");
            System.out.println("4. Delete Food");
            System.out.println("5. Back");
            System.out.println("====================");
            System.out.print(">> ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("=== Opsi Create Food ===");
                    System.out.print("FoodName    >> ");
                    String name = scanner.nextLine();
                    System.out.print("PrepTime    >> ");
                    String prepTime = scanner.nextLine();
                    System.out.print("Ingredients >> ");
                    String ingredients = scanner.nextLine();
                    menu.add(new Food(menu.size() + 1, name, 0, prepTime, ingredients));
                    System.out.println("Food created successfully!");
                    break;
                case 2:
                    System.out.println("=== Opsi Show Food ===");
                    if (menu.isEmpty()) {
                        System.out.println("data kosong!");
                    } else {
                        for (Food food : menu) {
                            food.getDetails();
                        }
                    }
                    break;
                case 3:
                    System.out.println("=== Opsi Update Food ===");
                    System.out.print("FoodId >> ");
                    int foodId = scanner.nextInt();
                    scanner.nextLine();
                    if (foodId > 0 && foodId <= menu.size()) {
                        Food food = menu.get(foodId - 1);
                        System.out.print("FoodName    >> ");
                        food.name = scanner.nextLine();
                        System.out.print("PrepTime    >> ");
                        food.preparationTime = scanner.nextLine();
                        System.out.print("Ingredients >> ");
                        food.ingredients = scanner.nextLine();
                        System.out.println("Food updated successfully!");
                    } else {
                        System.out.println("Invalid FoodId!");
                    }
                    break;
                case 4:
                    System.out.println("=== Opsi Delete Food ===");
                    System.out.print("FoodId >> ");
                    foodId = scanner.nextInt();
                    if (foodId > 0 && foodId <= menu.size()) {
                        menu.remove(foodId - 1);
                        System.out.println("Food deleted successfully!");
                    } else {
                        System.out.println("Invalid FoodId!");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }

    public void updateOrderStatus(ArrayList<Order> orders) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Update Order Status ===");
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();
        if (orderId > 0 && orderId <= orders.size()) {
            Order order = orders.get(orderId - 1);
            System.out.print("Enter new status: ");
            String newStatus = scanner.nextLine();
            order.updateStatus(newStatus);
        } else {
            System.out.println("Invalid Order ID!");
        }
    }

    public void processOrders() {
        System.out.println("Processing orders...");
    }

    public void viewStats() {
        System.out.println("Viewing stats...");
    }

    @Override
    public void login() {
        System.out.println("Seller logged in.");
    }

    @Override
    public void logout() {
        System.out.println("Seller logged out.");
    }

    @Override
    public void updateProfile() {
        System.out.println("Profile updated.");
    }
}
