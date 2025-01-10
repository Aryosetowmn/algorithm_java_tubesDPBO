/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserManagement;

import MenuManagement.Drinks;
import MenuManagement.Food;
import MenuManagement.MenuManagement;
import OrderManagement.Order;
import java.util.ArrayList;
import java.util.Scanner;

public class Seller extends User {
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

     public void manageMenu(ArrayList<MenuManagement> menu) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("==== Opsi Menu ====");
            System.out.println("1. Create Menu");
            System.out.println("2. Show Menu");
            System.out.println("3. Update Menu");
            System.out.println("4. Delete Menu");
            System.out.println("5. Back");
            System.out.println("====================");
            System.out.print(">> ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("=== Opsi Create Menu ===");
                    System.out.println("1. Create Food");
                    System.out.println("2. Create drink");
                    System.out.println(">> ");
                    int createChoices = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Name    >> ");
                    String name = scanner.nextLine();
                    System.out.println("Price    >>");
                    float price = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Stock    >>");
                    int stock = scanner.nextInt();
                    scanner.nextLine();
                switch (createChoices) {
                    case 1:
                        System.out.print("PrepTime    >> ");
                        String prepTime = scanner.nextLine();
                        System.out.print("Ingredients >> ");
                        String ingredients = scanner.nextLine();
                        menu.add(new Food(menu.size() + 1, name, price, prepTime, ingredients.split(","),stock));
                        break;
                    case 2:
                        System.out.print("Volume    >> ");
                        int volume = scanner.nextInt();
                        System.out.print("Is Hot >> ");
                        boolean isHot = scanner.nextBoolean();
                        menu.add(new Drinks(menu.size()+1, name, price, volume, isHot, stock));
                        break;
                    default:
                        System.out.println("[error]masukan pilihan yang benar");
                        break;
                }
                case 2:
                    System.out.println("=== Opsi Show Menu ===");
                    if (menu.isEmpty()) {
                        System.out.println("data kosong!");
                    } else {
                        System.out.println("== List menu Food ==");
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
                    break;
                case 3:
                    System.out.println("=== Opsi Update Menu ===");
                    System.out.print("MenuId >> ");
                    int menuId = scanner.nextInt();
                    scanner.nextLine();
                    if (menuId > 0 && menuId <= menu.size()) {
                        MenuManagement menus = menu.get(menuId - 1);
                        if(menus instanceof Food){
                            Food food = (Food) menus;
                            System.out.print("FoodName    >> ");
                            name = scanner.nextLine();
                            food.setName(name);
                            System.out.print("PrepTime    >> ");
                            String preparationTime = scanner.nextLine();
                            food.setPreparationTime(preparationTime);
                            System.out.print("Price    >> ");
                            price = scanner.nextInt();
                            food.setPrice(price);
                            scanner.nextLine();
                            System.out.print("Ingredients >> ");
                            String[] ingredients = scanner.nextLine().split(",");
                            food.setIngredients(ingredients);
                        }else {
                            Drinks drink = (Drinks) menus;
                            System.out.print("FoodName    >> ");
                            name = scanner.nextLine();
                            drink.setName(name);
                            System.out.print("Price    >> ");
                            price = scanner.nextInt();
                            scanner.nextLine();
                            drink.setPrice(price);
                            System.out.print("Volume    >> ");
                            int volume = scanner.nextInt();
                            drink.updateVolume(volume);
                            System.out.print("isHot    >> ");
                            boolean isHot = scanner.nextBoolean();
                            drink.setTemperature(isHot);
                        }
                        System.out.println("Menu updated successfully!");
                    } else {
                        System.out.println("Invalid FoodId!");
                    }
                    break;
                case 4:
                    System.out.println("=== Opsi Delete Menu ===");
                    System.out.print("MenuId >> ");
                    menuId = scanner.nextInt();
                    scanner.nextLine();
                    if (menuId > 0 && menuId <= menu.size()) {
                        for (int i = 0; i < menu.size(); i++) {
                            MenuManagement get = menu.get(i);
                            if(menuId == get.getId()){
                               menu.remove(i);
                               System.out.println("Berhasil di hapus");
                               break;
                            }
                        }
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

    public void updateProfile(ArrayList<Buyer> buyer,int indx) {
        System.out.println("Profile updated.");
    }
}
