/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaymentManagement;

public abstract class PaymentManagement {
    protected int orderId;
    protected float amount;

    public PaymentManagement(int orderId, float amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    public abstract void processPayment();
}