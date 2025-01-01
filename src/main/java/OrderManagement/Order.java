/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OrderManagement;

public class Order implements OrderActions{
    public int id;
    public int userId;
    public float total;
    public String status;
    public String notes;
    public String estimateDateTime;

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
