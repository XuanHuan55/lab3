/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2_lab3;

/**
 *
 * @author ASUS
 */
abstract class Employee {
    private String id;
    String name;
    int yearOfBirth;
    String address;
    String phone;
    double payment;

    public Employee() {
    }

    public Employee(String id, String name, int yearOfBirth, String address, String phone,double payment) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
        this.phone = phone;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }
    
    public abstract void calculatePayment();
    
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Year of birth: " + yearOfBirth + ", Address: " + address  + ", Payment: $" + payment;
    }
    
    public void getInfo(){
        
    }
}
