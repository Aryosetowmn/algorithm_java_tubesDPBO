/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Table;

public class Table {
    int id;
    int userId;
    boolean isAvailable;

    public Table(int id, boolean isAvailable) {
        this.id = id;
        this.isAvailable = isAvailable;
        this.userId = 0;
    }
    
    public void setUserId(int userId){
        this.userId = userId;
    }
    public int getUserId() {
        return userId;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    
    public void updateAvailability(boolean availability) {
        this.isAvailable = availability;
    }

}
