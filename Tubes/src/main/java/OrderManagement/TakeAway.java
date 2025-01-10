/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OrderManagement;

public class TakeAway extends Order {
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
