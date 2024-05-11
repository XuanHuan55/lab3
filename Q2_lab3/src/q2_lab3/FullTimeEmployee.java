/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2_lab3;

/**
 *
 * @author ASUS
 */
public class FullTimeEmployee extends Employee{
    private float salary;

    public FullTimeEmployee(int id, String name, int yearOfBirth, String address, String phone, double salary1) {
    }

    public FullTimeEmployee(float salary, String id, String name, int yearOfBirth, String address, String phone,double payment) {
        super(id, name, yearOfBirth, address, phone,payment);
        this.salary = salary;
    }
    public void calculatePayment(){
        payment = salary;
    }
}
