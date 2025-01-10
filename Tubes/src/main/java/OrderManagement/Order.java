/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OrderManagement;

public class Order extends OrderActions {
    private int id;
    int userId;
    private float total;
    private String status;
    private String notes;
    private String estimateDateTime;

    
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getEstimateDateTime() {
        return estimateDateTime;
    }

    public void setEstimateDateTime(String estimateDateTime) {
        this.estimateDateTime = estimateDateTime;
    }
    
}
