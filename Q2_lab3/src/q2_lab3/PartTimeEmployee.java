/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2_lab3;

/**
 *
 * @author ASUS
 */
public class PartTimeEmployee extends Employee {

    private int workingHour;
    private float payRate;

    public PartTimeEmployee() {
    }

    public PartTimeEmployee(int workingHour, float payRate, String id, String name, int yearOfBirth, String address, String phone) {
        super(id, name, yearOfBirth, address, phone);
        this.workingHour = workingHour;
        this.payRate = payRate;
    }
@Override
    public String getInfo() {
        return "ID: " + id + ", Name: " + name + ", Year of birth: " + yearOfBirth + ", Address: " + address + ", Phone: " + phone + ", Working hours: " + workingHour + ", payment per hour: " + payRate + ", salary: " + getPayment();
    }

    @Override
    public float getPayment() {
        return workingHour * payRate;
    }

}
