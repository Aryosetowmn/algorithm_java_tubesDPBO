/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaymentManagement;

import OrderManagement.Order;
import java.util.Scanner;

public class Payment {
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
                System.out.println("Total Harga: " + order.getTotal());
                System.out.println("======================");
                System.out.print("Bayar >> ");
                int paidAmount = scanner.nextInt();
                scanner.nextLine();
                Cash cashPayment = new Cash(order.getId(), order.getTotal(), paidAmount);
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
                Cashless cashlessPayment = new Cashless(order.getId(), order.getTotal(), paymentMethod);
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