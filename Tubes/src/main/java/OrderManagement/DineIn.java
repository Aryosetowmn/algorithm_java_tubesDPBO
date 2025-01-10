/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OrderManagement;

import Table.Table;
import java.util.ArrayList;

public class DineIn extends Order {
    private int tableNumber;
    private ArrayList<Table> tables;

    public DineIn(int id, int userId, float total, String status, String notes, String estimateDateTime, ArrayList<Table> tables) {
        super(id, userId, total, status, notes, estimateDateTime);
        this.tables = tables;
        this.tableNumber = assignTable();
    }

    private int assignTable() {
        for (Table table : tables) {
            if(table.getUserId() == super.userId){
                System.out.println("Thankyou!!");
                return table.getId();
            }else { 
                if (table.isIsAvailable()) {
                    table.updateAvailability(false);
                    table.setUserId(super.userId);
                    System.out.println("Table " + table.getId() + " assigned.");
                    return table.getId();
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
