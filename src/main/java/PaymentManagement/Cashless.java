/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaymentManagement;

public class Cashless extends PaymentManagement {
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
