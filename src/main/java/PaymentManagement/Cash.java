/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaymentManagement;

public class Cash extends PaymentManagement{
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
