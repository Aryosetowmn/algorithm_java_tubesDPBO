/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OrderManagement;

public class DineIn extends Order{
    private int tableNumber;
    private int numberOfGuests;

    public DineIn(int id, int userId, float total, String status, String notes, String estimateDateTime, int tableNumber, int numberOfGuests) {
        super(id, userId, total, status, notes, estimateDateTime);
        this.tableNumber = tableNumber;
        this.numberOfGuests = numberOfGuests;
    }

    public void assignTable() {
        System.out.println("Table assigned.");
    }

    public void updateTableStatus() {
        System.out.println("Table status updated.");
    }
}
