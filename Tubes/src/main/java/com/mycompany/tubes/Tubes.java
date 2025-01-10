
package com.mycompany.tubes;

import MenuManagement.MenuManagement;
import OrderManagement.Order;
import Table.Table;
import UserManagement.Admin;
import UserManagement.Buyer;
import UserManagement.Seller;
import java.util.ArrayList;
import java.util.Scanner;

public class Tubes {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<MenuManagement> menu = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();
        // pusat table
        ArrayList<Table> tables = new ArrayList<>();
        ArrayList<Buyer> buyerAccount = new ArrayList<>();
        ArrayList<Buyer> buyerQueue = new ArrayList<>();
        
        // Initialize some tables
        tables.add(new Table(1, true));
        tables.add(new Table(2, true));
        tables.add(new Table(3, true));

        Seller seller = new Seller(1, "John Doe", "seller@example.com", "123456789", "John's Store", 4.5f);
        Admin admin = new Admin(1, "Admin", "admin@example.com", "987654321");
        buyerAccount.add(new Buyer(buyerAccount.size() + 1, "Jane Doe", "buyer@example.com", "555555555", "123 Main St", "JaneDoe"));
        buyerQueue.add(new Buyer(buyerQueue.size() + 1, "budi", "buyer@example.com", "555555555", "123 Main St", "budi123"));
        int choice = 1;
        
        while (choice != 0) {
            System.out.println("=== Login Options ===");
            System.out.println("1. Login Admin");
            System.out.println("2. Login Seller");
            System.out.println("3. Login Buyer");
            System.out.println("4. Register Buyer");
            System.out.println("0. Exit Program");
            System.out.println("=====================");
            System.out.print(">> ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (authenticate("admin", "admin123")) {
                        admin.login();
                        while (true) {
                            System.out.println("=== Admin Menu ===");
                            System.out.println("1. Manage Menu");
                            System.out.println("2. Manage Account");
                            System.out.println("3. Logout");
                            System.out.println("===================");
                            System.out.print(">> ");
                            int adminChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (adminChoice) {
                                case 1:
                                    admin.manageMenu(menu);
                                    break;
                                case 2:
                                    admin.manageAccount(buyerAccount, buyerQueue);
                                    break;
                                case 3:
                                    admin.logout();
                                    break;
                                default:
                                    System.out.println("Invalid choice, try again!");
                            }
                            if (adminChoice == 3) break;
                        }
                    } else {
                        System.out.println("Invalid credentials!");
                    }
                    break;
                case 2:
                    if (authenticate("seller", "seller123")) {
                        seller.login();
                        while (true) {
                            System.out.println("=== Seller Menu ===");
                            System.out.println("1. Manage Menu");
                            System.out.println("2. Update Order Status");
                            System.out.println("3. Logout");
                            System.out.println("===================");
                            System.out.print(">> ");
                            int sellerChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (sellerChoice) {
                                case 1:
                                    seller.manageMenu(menu);
                                    break;
                                case 2:
                                    seller.updateOrderStatus(orders);
                                    break;
                                case 3:
                                    seller.logout();
                                    break;
                                default:
                                    System.out.println("Invalid choice, try again!");
                            }
                            if (sellerChoice == 3) break;
                        }
                    } else {
                        System.out.println("Invalid credentials!");
                    }
                    break;
                case 3:
                    int indX = authenticate(buyerAccount);
                    if (indX != -1) {
                        buyerAccount.get(indX).login();
                        while (true) {
                            System.out.println("=== Buyer Menu ===");
                            System.out.println("1. Browse Menu");
                            System.out.println("2. Place Order");
                            System.out.println("3. View Orders");
                            // System.out.println("4. Update Profile");
                            System.out.println("4. Logout");
                            System.out.println("==================");
                            System.out.print(">> ");
                            int buyerChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (buyerChoice) {
                                case 1:
                                    buyerAccount.get(indX).browseMenu(menu);
                                    break;
                                case 2:
                                    buyerAccount.get(indX).placeOrder(orders, buyerAccount.get(indX).getId(), menu, tables);
                                    break;
                                case 3:
                                    buyerAccount.get(indX).viewOrders(orders);
                                    break;
//                                case 4:
//                                    buyerAccount.get(indX).updateProfile(buyerAccount, indX);
//                                    break;
                                case 4:
                                    buyerAccount.get(indX).logout();
                                    break;
                                default:
                                    System.out.println("Invalid choice, try again!");
                            }
                            if (buyerChoice == 5) break;
                        }
                    } else {
                        System.out.println("Invalid credentials!");
                        
                    }
                    break;
                case 4:
                    System.out.println("=== Opsi Register Buyer ===");
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
                            if(buyerQueue.size() == 0){
                                buyerQueue.add(buyerQueue.size(), new Buyer(buyerAccount.size()+1, name, email, phone, address, password));
                            } else {
                                //System.out.println(buyerAccount.get(buyerAccount.size()-1).getId()+1);
                                 buyerQueue.add(buyerQueue.size(), new Buyer(buyerAccount.get(buyerAccount.size()-1).getId()+1, name, email, phone, address, password));
                            }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }

    private static boolean authenticate(String username, String password) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();
        return inputUsername.equals(username) && inputPassword.equals(password);
    }
    
    private static int authenticate(ArrayList<Buyer> buyer){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();
        for (int i = 0  ; i < buyer.size(); i++) {
            Buyer get = buyer.get(i);
            if(inputUsername.equals(get.getName()) && inputPassword.equals(get.getPassword())){
                return i;
            }
        }
        return -1;
    }
}