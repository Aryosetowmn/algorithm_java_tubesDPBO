/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserManagement;

import MenuManagement.Food;
import OrderManagement.Order;
import java.util.ArrayList;
import java.util.Scanner;

public class Buyer extends User  {
    private String address;

    public Buyer(int id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public void browseMenu(ArrayList<MenuManagement.Food> menu) {
        System.out.println("=== Menu ===");
        if (menu.isEmpty()) {
            System.out.println("No food available!");
        } else {
            for (MenuManagement.Food food: menu) {
                food.getDetails();
            }
        }
    }

    public void placeOrder(ArrayList<Order> orders, int userId, ArrayList<MenuManagement.Food> menu) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Place Order ===");
        System.out.print("Enter Food ID: ");
        int foodId = scanner.nextInt();
        scanner.nextLine();
        if (foodId > 0 && foodId <= menu.size()) {
            MenuManagement.Food food = menu.get(foodId - 1);
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            float total = food.price* quantity;
            Order order = new Order(orders.size() + 1, userId, total, "Pending", "", "N/A");
            orders.add(order);
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Invalid Food ID!");
        }
    }

    public void viewOrders(ArrayList<OrderManagement.Order> orders) {
        System.out.println("=== Your Orders ===");
        for (OrderManagement.Order order : orders) {
            if (order.userId == this.id) {
                System.out.println("Order ID: " + order.id);
                System.out.println("Total: " + order.total);
                System.out.println("Status: " + order.status);
                System.out.println("Notes: " + order.notes);
                System.out.println("Estimate DateTime: " + order.estimateDateTime);
                System.out.println("-------------------");
            }
        }
    }

    @Override
    public void login() {
        System.out.println("Buyer logged in.");
    }

    @Override
    public void logout() {
        System.out.println("Buyer logged out.");
    }

    @Override
    public void updateProfile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter new email: ");
        this.email = scanner.nextLine();
        System.out.print("Enter new phone: ");
        this.phone = scanner.nextLine();
        System.out.print("Enter new address: ");
        this.address = scanner.nextLine();
        System.out.println("Profile updated successfully!");
    }
}
