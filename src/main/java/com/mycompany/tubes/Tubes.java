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

    public abstract void login();
    public abstract void logout();
    public abstract void updateProfile();
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
                    menu.add(new Food(menu.size() + 1, name, 0, prepTime, ingredients.split(",")));
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
                        food.ingredients = scanner.nextLine().split(",");
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

class Admin extends User {
    private int adminLevel;

    public Admin(int id, String name, String email, String phone, int adminLevel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.adminLevel = adminLevel;
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
                    menu.add(new Food(menu.size() + 1, name, 0, prepTime, ingredients.split(",")));
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
                        food.ingredients = scanner.nextLine().split(",");
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

    public void processOrders() {
        System.out.println("Processing orders...");
    }

    public void viewStats() {
        System.out.println("Viewing stats...");
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
    public void updateProfile() {
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

    public Buyer(int id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public void browseMenu(ArrayList<Food> menu) {
        System.out.println("=== Menu ===");
        if (menu.isEmpty()) {
            System.out.println("No food available!");
        } else {
            for (Food food : menu) {
                food.getDetails();
            }
        }
    }

    public void placeOrder(ArrayList<Order> orders, int userId, ArrayList<Food> menu) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Place Order ===");
        System.out.print("Enter Food ID: ");
        int foodId = scanner.nextInt();
        scanner.nextLine();
        if (foodId > 0 && foodId <= menu.size()) {
            Food food = menu.get(foodId - 1);
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            float total = food.price * quantity;
            Order order = new Order(orders.size() + 1, userId, total, "Pending", "", "N/A");
            orders.add(order);
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Invalid Food ID!");
        }
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

public class Tubes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Food> menu = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();
        Seller seller = new Seller(1, "John Doe", "seller@example.com", "123456789", "John's Store", 4.5f);
        Admin admin = new Admin(1, "Admin", "admin@example.com", "987654321", 1);
        Buyer buyer = new Buyer(1, "Jane Doe", "buyer@example.com", "555555555", "123 Main St");
        int choice = 1;
        
        while (choice != 0) {
            System.out.println("=== Login Options ===");
            System.out.println("1. Login Admin");
            System.out.println("2. Login Seller");
            System.out.println("3. Login Buyer");
            System.out.println("0. Exit Program");
            System.out.println("=====================");
            System.out.print(">> ");
            choice = scanner.nextInt();
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
}
class Table {
    int id;
    boolean isAvailable;

    public Table(int id, boolean isAvailable) {
        this.id = id;
        this.isAvailable = isAvailable;
    }

    public void updateAvailability(boolean availability) {
        this.isAvailable = availability;
    }
}

class DineIn extends Order {
    private int tableNumber;
    private int numberOfGuests;
    private ArrayList<Table> tables;

    public DineIn(int id, int userId, float total, String status, String notes, String estimateDateTime, int numberOfGuests, ArrayList<Table> tables) {
        super(id, userId, total, status, notes, estimateDateTime);
        this.numberOfGuests = numberOfGuests;
        this.tables = tables;
        this.tableNumber = assignTable();
    }

    private int assignTable() {
        for (Table table : tables) {
            if (table.isAvailable) {
                table.updateAvailability(false);
                System.out.println("Table " + table.id + " assigned.");
                return table.id;
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

class Food {
    protected int id;
    protected String name;
    protected float price;
    protected String preparationTime;
    protected String[] ingredients;

    public Food(int id, String name, float price, String preparationTime, String[] ingredients) {
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

class Drink extends Food {
    private int volume;
    private boolean isHot;

    public Drink(int id, String name, float price, String preparationTime, String[] ingredients, int volume, boolean isHot) {
        super(id, name, price, preparationTime, ingredients);
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
                    System.out.println("Terimakasih, Silahkan menuju ke meja anda!");
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