/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2_lab3;

/**
 *
 * @author ASUS
 */
public class FullTimeEmployee extends Employee {

    private float salary;

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(float salary, String id, String name, int yearOfBirth, String address, String phone) {
        super(id, name, yearOfBirth, address, phone);
        this.salary = salary;
    }

    @Override
    public String getInfo() {
        return "ID: " + id + ", Name: " + name + ", Year of birth: " + yearOfBirth + ", Address: " + address + ", Phone: " + phone + ", salary: " + salary;
    }
    @Override
    public float getPayment() {
        return salary;
    }
}
