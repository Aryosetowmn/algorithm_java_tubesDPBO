/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuManagement;

public class Drinks extends MenuManagement {
    private int volume;
    private boolean isHot;

    public Drinks(int id, String name, float price, int volume, boolean isHot, int stock) {
        super(id, price, stock);
        this.volume = volume;
        this.isHot = isHot;
    }

    public void updateVolume(int newVolume) {
        this.volume = newVolume;
        System.out.println("Volume updated to: " + newVolume);
    }

    public void setTemperature(boolean isHot) {
        this.isHot = isHot;
        System.out.println("Temperature set to: " + (isHot ? "Hot" : "Cold"));
    }
    public void getDetails() {
        System.out.println("Id          >> " + id);
        System.out.println("FoodName    >> " + name);
        System.out.println("Price    >> " + price);
        System.out.println("Stock    >> " + stock);
        System.out.println("Volume    >> " + volume);
        System.out.println("isHot >> " + isHot);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isIsHot() {
        return isHot;
    }

    public void setIsHot(boolean isHot) {
        this.isHot = isHot;
    }
    
    
}
