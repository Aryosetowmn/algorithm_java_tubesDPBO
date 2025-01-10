/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserManagement;

import MenuManagement.Drinks;
import MenuManagement.Food;
import MenuManagement.MenuManagement;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
    // private int adminLevel;
    // private ArrayList<Buyer> registerQeueu;
    
    public Admin(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
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
                            scanner.nextLine();
                            food.setPrice(price);
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
    public void manageAccount(ArrayList<Buyer> buyer, ArrayList<Buyer> queue) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("==== Opsi Menu ====");
            System.out.println("1. Show Buyer");
            System.out.println("2. Create Buyer");
            System.out.println("3. Delete buyer");
            System.out.println("4. Update buyer");
            System.out.println("5. Back");
            System.out.println("====================");
            System.out.print(">> ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    for (int i = 0; i < buyer.size(); i++) {
                        Buyer get = buyer.get(i);
                        System.out.println("Name: "+get.getName());
                    }
                    break;
                case 2:
                    // for queue
                    for (int i = 0; i < queue.size(); i++) {
                        Buyer get = queue.get(i);
                        buyer.add(new Buyer(buyer.get(buyer.size()-1).getId()+1, get.getName(), get.getEmail(), get.getPhone(), get.getAddress(), get.getPassword()));
                        
                    }
                    
                    for (int i = 0; i < queue.size(); i++) {
                        queue.remove(i);
                    }
                   
                    
                    
                    break;
                case 3:
                    System.out.println("Masukan nama >>");
                    String nama = scanner.nextLine();
                    System.out.println(nama);
                    for (int i = 0; i < buyer.size(); i++) {
                        Buyer get = buyer.get(i);
                        if(nama.equals(get.name)){
                            buyer.remove(i);
                            System.out.println("Data berhasil di hapus");
                        }else {
                            System.out.println("Data tidak ada");
                            
                        }
                    }
                    
                    break;
                case 4:
                    System.out.println("Masukan nama >>");
                    nama = scanner.nextLine();
                    for (int i = 0; i < buyer.size(); i++) {
                        Buyer get = buyer.get(i);
                        if(nama.equals(get.name)){
                            System.out.print("Enter new name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter new email: ");
                            String email = scanner.nextLine();
                            System.out.print("Enter new phone: ");
                            String phone = scanner.nextLine();
                            System.out.print("Enter new address: ");
                            String address = scanner.nextLine();
                            System.out.print("Enter new password: ");
                            String password = scanner.nextLine();
                            System.out.println("Profile updated successfully!");
                            buyer.set(i, new Buyer(buyer.get(i).getId(), name, email, phone, address, password));
                            
                        }else {
                            System.out.println("Data tidak ada");
                            
                        }
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice, try again!");
            }
            
        
        }
    }
    @Override
    public void login() {
        System.out.println("Admin logged in.");
    }

    @Override
    public void logout() {
        System.out.println("Admin logged out.");
    }
    public void updateProfile(ArrayList<Buyer> buyer,int indx) {
        System.out.println("Profile updated.");
    }
    
}