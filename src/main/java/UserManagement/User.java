/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserManagement;

/**
 *
 * @author X1
 */
abstract public class User {
    public int id;
    protected String name;
    protected String email;
    protected String phone;

    public abstract void login();
    public abstract void logout();
    public abstract void updateProfile();
}
