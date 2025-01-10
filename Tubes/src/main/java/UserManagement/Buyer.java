/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserManagement;

import MenuManagement.Drinks;
import MenuManagement.Food;
import MenuManagement.MenuManagement;
import OrderManagement.DineIn;
import OrderManagement.Order;
import OrderManagement.TakeAway;
import PaymentManagement.Payment;
import Table.Table;
import java.util.ArrayList;
import java.util.Scanner;

public class Buyer extends User {
    private String address;
    
    public Buyer(int id, String name, String email, String phone, String address, String pass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = pass;
    }

    public void browseMenu(ArrayList<MenuManagement> menu) {
        System.out.println("=== Menu ===");
        if (menu.isEmpty()) {
            System.out.println("data kosong!");
        } else {
            System.out.println("== Menu ==");
            System.out.println("== Food ==");
            for (MenuManagement menus : menu) {
                if(menus instanceof Food){
                    Food foods = (Food) menus;
                    foods.getDetails();
                }
                System.out.println("---------------");
            }
            System.out.println("== Drinks");
            for (MenuManagement menus : menu) {
                if(menus instanceof Drinks){
                    Drinks drinks = (Drinks) menus;
                    drinks.getDetails();
                }
                System.out.println("---------------");
            }
        }
    }
    public String getPassword() {
        return password;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void placeOrder(ArrayList<Order> orders, int userId, ArrayList<MenuManagement> menu, ArrayList<Table> tables) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Order Type ===");
        System.out.println("1. Dine In");
        System.out.println("2. Take Away");
        System.out.println("=================");
        System.out.print("Choose order type >> ");
        int orderType = scanner.nextInt();
        scanner.nextLine();

        // Show menu and get food order
        System.out.println("== Menu ==");
            System.out.println("== Food ==");
            for (MenuManagement menus : menu) {
                if(menus instanceof Food){
                    Food foods = (Food) menus;
                    foods.getDetails();
                }
                System.out.println("---------------");
            }
            System.out.println("== Drinks");
            for (MenuManagement menus : menu) {
                if(menus instanceof Drinks){
                    Drinks drinks = (Drinks) menus;
                    drinks.getDetails();
                }
                System.out.println("---------------");
            }
        System.out.print("Enter Food ID: ");
        int menuId = scanner.nextInt();
        scanner.nextLine();
        if (menuId > 0 && menuId <= menu.size()) {
            MenuManagement menus = menu.get(menuId - 1);
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            // kondisi kalo yang di pesan melebihi stock dan menguranginya
            if(quantity > menus.getStock()){
                System.out.println("[error] stock kurang");
                return;
            }else{
                menus.updateStock(menuId, quantity, menu);
            }
            float total = menus.getPrice() * quantity;
            Order order;
            if (orderType == 1) { // Dine In
                order = new DineIn(orders.size() + 1, userId, total, "Pending", "", 
                getCurrentDateTime(), tables);
            } else { // Take Away
                System.out.print("Enter pickup time (HH:mm): ");
                String pickupTime = scanner.nextLine();
                System.out.print("Enter packaging notes: ");
                String packagingNotes = scanner.nextLine();
                order = new TakeAway(orders.size() + 1, userId, total, "Pending", "", 
                    getCurrentDateTime(), pickupTime, packagingNotes);
            }

            orders.add(order);
            System.out.println("Order placed successfully!");
            
            // Process payment
            Payment.processPayment(order);
        } else {
            System.out.println("Invalid Food ID!");
        }
    }

    private String getCurrentDateTime() {
        return java.time.LocalDateTime.now().toString();
    }

    public void viewOrders(ArrayList<Order> orders) {
        System.out.println("=== Your Orders ===");
        for (Order order : orders) {
            if (order.getUserId() == this.id) {
                System.out.println("Order ID: " + order.getId());
                System.out.println("Total: " + order.getTotal());
                System.out.println("Status: " + order.getStatus());
                System.out.println("Notes: " + order.getNotes());
                System.out.println("Estimate DateTime: " + order.getEstimateDateTime());
                
                if (order instanceof DineIn) {
                    System.out.println("Order Type: Dine In");
                } else if (order instanceof TakeAway) {
                    System.out.println("Order Type: Take Away");
                }
                
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

//    public void updateProfile(ArrayList<Buyer> buyer,int indx) {
//        
//    }
}