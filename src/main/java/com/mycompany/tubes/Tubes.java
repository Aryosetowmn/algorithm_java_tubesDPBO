/*package com.mycompany.tubes;
import MenuManagement.Food;
import OrderManagement.Order;
import UserManagement.Admin;
import UserManagement.Buyer;
import UserManagement.Seller;
import java.util.ArrayList;
import java.util.Scanner;


public class Tubes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Food> menu = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();
        Seller seller = new Seller(1, "John Doe", "seller@example.com", "123456789", "John's Store", 4.5f);
        Admin admin = new Admin(1, "Admin", "admin@example.com", "987654321", 1);
        Buyer buyer = new Buyer(1, "Jane Doe", "buyer@example.com", "555555555", "123 Main St");

        while (true) {
            System.out.println("=== Login Options ===");
            System.out.println("1. Login Admin");
            System.out.println("2. Login Seller");
            System.out.println("3. Login Buyer");
            System.out.println("=====================");
            System.out.print(">> ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (authenticate("admin", "admin123")) {
                        admin.login();
                        admin.manageMenu(menu);
                        admin.logout();
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
                    if (authenticate("buyer", "buyer123")) {
                        buyer.login();
                        while (true) {
                            System.out.println("=== Buyer Menu ===");
                            System.out.println("1. Browse Menu");
                            System.out.println("2. Place Order");
                            System.out.println("3. View Orders");
                            System.out.println("4. Update Profile");
                            System.out.println("5. Logout");
                            System.out.println("==================");
                            System.out.print(">> ");
                            int buyerChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (buyerChoice) {
                                case 1:
                                    buyer.browseMenu(menu);
                                    break;
                                case 2:
                                    buyer.placeOrder(orders, buyer.id, menu);
                                    break;
                                case 3:
                                    buyer.viewOrders(orders);
                                    break;
                                case 4:
                                    buyer.updateProfile();
                                    break;
                                case 5:
                                    buyer.logout();
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
}*/

package com.mycompany.tubes;
import java.util.ArrayList;
import java.util.Scanner;

abstract class OrderActions {
    public abstract void makeOrder();
    public abstract void editOrder();
    public abstract void trackOrder();
}

class Order extends OrderActions {
    int id;
    int userId;
    float total;
    String status;
    String notes;
    String estimateDateTime;

    public Order(int id, int userId, float total, String status, String notes, String estimateDateTime) {
        this.id = id;
        this.userId = userId;
        this.total = total;
        this.status = status;
        this.notes = notes;
        this.estimateDateTime = estimateDateTime;
    }

    public void calculateTotal() {
        System.out.println("Calculating total...");
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("Order status updated to: " + newStatus);
    }

    @Override
    public void makeOrder() {
        System.out.println("Order created.");
    }

    @Override
    public void editOrder() {
        System.out.println("Order edited.");
    }

    @Override
    public void trackOrder() {
        System.out.println("Tracking order...");
    }
}

// class DineIn extends Order {
//     private int tableNumber;
//     private int numberOfGuests;

//     public DineIn(int id, int userId, float total, String status, String notes, String estimateDateTime, int tableNumber, int numberOfGuests) {
//         super(id, userId, total, status, notes, estimateDateTime);
//         this.tableNumber = tableNumber;
//         this.numberOfGuests = numberOfGuests;
//     }

//     public void assignTable() {
//         System.out.println("Table assigned.");
//     }

//     public void updateTableStatus() {
//         System.out.println("Table status updated.");
//     }
// }

// class TakeAway extends Order {
//     private String pickupTime;
//     private String packagingNotes;

//     public TakeAway(int id, int userId, float total, String status, String notes, String estimateDateTime, String pickupTime, String packagingNotes) {
//         super(id, userId, total, status, notes, estimateDateTime);
//         this.pickupTime = pickupTime;
//         this.packagingNotes = packagingNotes;
//     }

//     public void estimatePickupTime() {
//         System.out.println("Pickup time estimated.");
//     }

//     public void updatePickupStatus() {
//         System.out.println("Pickup status updated.");
//     }
// }

abstract class User {
    protected int id;
    protected String name;
    protected String email;
    protected String phone;
    protected String password;
    public abstract void login();
    public abstract void logout();
    public abstract void updateProfile(ArrayList<Buyer> buyer,int indx);
}

class Seller extends User {
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
                        menu.add(new Drink(menu.size()+1, name, price, volume, isHot, stock));
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
                            if(menus instanceof Drink){
                                Drink drinks = (Drink) menus;
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
                            food.name = scanner.nextLine();
                            System.out.print("PrepTime    >> ");
                            food.preparationTime = scanner.nextLine();
                            System.out.print("Price    >> ");
                            food.price = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Ingredients >> ");
                            food.ingredients = scanner.nextLine().split(",");
                        }else {
                            Drink drink = (Drink) menus;
                            System.out.print("FoodName    >> ");
                            drink.name = scanner.nextLine();
                            System.out.print("Price    >> ");
                            drink.price = scanner.nextInt();
                            scanner.nextLine();
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
                            if(menuId == get.id){
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

    @Override
    public void updateProfile(ArrayList<Buyer> buyer,int indx) {
        System.out.println("Profile updated.");
    }
}

class Admin extends User {
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
                        menu.add(new Drink(menu.size()+1, name, price, volume, isHot, stock));
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
                            if(menus instanceof Drink){
                                Drink drinks = (Drink) menus;
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
                            food.name = scanner.nextLine();
                            System.out.print("PrepTime    >> ");
                            food.preparationTime = scanner.nextLine();
                            System.out.print("Price    >> ");
                            food.price = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Ingredients >> ");
                            food.ingredients = scanner.nextLine().split(",");
                        }else {
                            Drink drink = (Drink) menus;
                            System.out.print("FoodName    >> ");
                            drink.name = scanner.nextLine();
                            System.out.print("Price    >> ");
                            drink.price = scanner.nextInt();
                            scanner.nextLine();
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
                            if(menuId == get.id){
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

    @Override
    public void updateProfile(ArrayList<Buyer> buyer,int indx) {
        System.out.println("Profile updated.");
    }
    
}

// class Food {
//     protected int id;
//     protected String name;
//     protected float price;
//     protected String preparationTime;
//     protected String ingredients;

//     public Food(int id, String name, float price, String preparationTime, String ingredients) {
//         this.id = id;
//         this.name = name;
//         this.price = price;
//         this.preparationTime = preparationTime;
//         this.ingredients = ingredients;
//     }

//     public void getDetails() {
//         System.out.println("Id          >> " + id);
//         System.out.println("FoodName    >> " + name);
//         System.out.println("PrepTime    >> " + preparationTime);
//         System.out.println("Ingredients >> " + ingredients);
//     }
// }

class Buyer extends User {
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
                if(menus instanceof Drink){
                    Drink drinks = (Drink) menus;
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
                if(menus instanceof Drink){
                    Drink drinks = (Drink) menus;
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
            if(quantity > menus.stock){
                System.out.println("[error] stock kurang");
                return;
            }else{
                menus.updateStock(menuId, quantity, menu);
            }
            float total = menus.price * quantity;
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
            if (order.userId == this.id) {
                System.out.println("Order ID: " + order.id);
                System.out.println("Total: " + order.total);
                System.out.println("Status: " + order.status);
                System.out.println("Notes: " + order.notes);
                System.out.println("Estimate DateTime: " + order.estimateDateTime);
                
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

    @Override
    public void updateProfile(ArrayList<Buyer> buyer,int indx) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter new email: ");
        this.email = scanner.nextLine();
        System.out.print("Enter new phone: ");
        this.phone = scanner.nextLine();
        System.out.print("Enter new address: ");
        this.address = scanner.nextLine();
        System.out.print("Enter new password: ");
        this.password = scanner.nextLine();
        System.out.println("Profile updated successfully!");
        buyer.set(indx, new Buyer(buyer.get(indx).getId(), name, email, phone, address, password));
    }
}

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
                            System.out.println("4. Update Profile");
                            System.out.println("5. Logout");
                            System.out.println("==================");
                            System.out.print(">> ");
                            int buyerChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (buyerChoice) {
                                case 1:
                                    buyerAccount.get(indX).browseMenu(menu);
                                    break;
                                case 2:
                                    buyerAccount.get(indX).placeOrder(orders, buyerAccount.get(indX).id, menu, tables);
                                    break;
                                case 3:
                                    buyerAccount.get(indX).viewOrders(orders);
                                    break;
                                case 4:
                                    buyerAccount.get(indX).updateProfile(buyerAccount, indX);
                                    break;
                                case 5:
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

class Table {
    int id;
    int userId;
    boolean isAvailable;

    public Table(int id, boolean isAvailable) {
        this.id = id;
        this.isAvailable = isAvailable;
        this.userId = 0;
    }
    
    public void setUserId(int userId){
        this.userId = userId;
    }
    public int getUserId() {
        return userId;
    }
    
    public void updateAvailability(boolean availability) {
        this.isAvailable = availability;
    }
}

class DineIn extends Order {
    private int tableNumber;
    private ArrayList<Table> tables;

    public DineIn(int id, int userId, float total, String status, String notes, String estimateDateTime, ArrayList<Table> tables) {
        super(id, userId, total, status, notes, estimateDateTime);
        this.tables = tables;
        this.tableNumber = assignTable();
    }

    private int assignTable() {
        for (Table table : tables) {
            if(table.userId == super.userId){
                System.out.println("Thankyou!!");
                return table.id;
            }else { 
                if (table.isAvailable) {
                    table.updateAvailability(false);
                    table.setUserId(super.userId);
                    System.out.println("Table " + table.id + " assigned.");
                    return table.id;
                }  
            }
            
        }
        System.out.println("No available tables.");
        return -1;
    }

    public void updateTableStatus() {
        System.out.println("Table status updated.");
    }
}

class TakeAway extends Order {
    private String pickupTime;
    private String packagingNotes;

    public TakeAway(int id, int userId, float total, String status, String notes, String estimateDateTime, String pickupTime, String packagingNotes) {
        super(id, userId, total, status, notes, estimateDateTime);
        this.pickupTime = pickupTime;
        this.packagingNotes = packagingNotes;
    }

    public void estimatePickupTime() {
        System.out.println("Pickup time estimated.");
    }

    public void updatePickupStatus() {
        System.out.println("Pickup status updated.");
    }
}

class MenuManagement {
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
    
}

class Food extends MenuManagement {
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
}

class Drink extends MenuManagement {
    private int volume;
    private boolean isHot;

    public Drink(int id, String name, float price, int volume, boolean isHot, int stock) {
        super(id, price, stock);
        this.volume = volume;
        this.isHot = isHot;
    }

    public void updateVolume(int newVolume) {
        this.volume = newVolume;
        System.out.println("Volume updated to: " + newVolume);
    }

    public void setTemperature(boolean isHot) {
        this.isHot = isHot;
        System.out.println("Temperature set to: " + (isHot ? "Hot" : "Cold"));
    }
    public void getDetails() {
        System.out.println("Id          >> " + id);
        System.out.println("FoodName    >> " + name);
        System.out.println("Price    >> " + price);
        System.out.println("Stock    >> " + stock);
        System.out.println("Volume    >> " + volume);
        System.out.println("isHot >> " + isHot);
    }
    
}

abstract class PaymentManagement {
    protected int orderId;
    protected float amount;

    public PaymentManagement(int orderId, float amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    public abstract void processPayment();
}

class Cash extends PaymentManagement {
    private int paidAmount;

    public Cash(int orderId, float amount, int paidAmount) {
        super(orderId, amount);
        this.paidAmount = paidAmount;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing cash payment...");
    }

    public int calculateChange() {
        return paidAmount - (int) amount;
    }

    public boolean validateCash() {
        return paidAmount >= amount;
    }
}

class Cashless extends PaymentManagement {
    private String paymentMethod;

    public Cashless(int orderId, float amount, String paymentMethod) {
        super(orderId, amount);
        this.paymentMethod = paymentMethod;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing cashless payment...");
    }

    public boolean validateTransaction() {
        // Implement validation logic here
        return true;
    }
}
class Payment {
    public static void processPayment(Order order) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====Opsi Payment=====");
        System.out.println("1. Cash");
        System.out.println("2. Cashless");
        System.out.println("======================");
        System.out.print(">> ");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine();

        switch (paymentChoice) {
            case 1:
                System.out.println("======================");
                System.out.println("Total Harga: " + order.total);
                System.out.println("======================");
                System.out.print("Bayar >> ");
                int paidAmount = scanner.nextInt();
                scanner.nextLine();
                Cash cashPayment = new Cash(order.id, order.total, paidAmount);
                if (cashPayment.validateCash()) {
                    cashPayment.processPayment();
                    System.out.println("======================");
                    System.out.println("Kembalian: " + cashPayment.calculateChange());
                    System.out.println("Terimakasih atas pembelian anda!");
                } else {
                    System.out.println("======================");
                    System.out.println("Uang Tidak Cukup, Masukkan uang kembali!");
                    processPayment(order);
                }
                break;
            case 2:
                System.out.println("======================");
                System.out.print("Payment Methods >> ");
                String paymentMethod = scanner.nextLine();
                Cashless cashlessPayment = new Cashless(order.id, order.total, paymentMethod);
                if (cashlessPayment.validateTransaction()) {
                    cashlessPayment.processPayment();
                    System.out.println("Payment Method valid!");
                    System.out.println("Terimakasih, Silahkan ambil pesanan pada kasir.");
                } else {
                    System.out.println("Payment Method invalid!");
                    processPayment(order);
                }
                break;
            default:
                System.out.println("Invalid choice, try again!");
                processPayment(order);
        }
    }
}