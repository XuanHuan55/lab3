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

    public PartTimeEmployee(int id, String name, int yearOfBirth, String address, String phone, int workingHours, double payRate1) {
    }

    public PartTimeEmployee(int workingHour, float payRate, String id, String name, int yearOfBirth, String address, String phone,double payment) {
        super(id, name, yearOfBirth, address, phone,payment);
        this.workingHour = workingHour;
        this.payRate = payRate;
    }
    
    public void calculatePayment(){
        payment = workingHour * payRate;
    }
     
}
