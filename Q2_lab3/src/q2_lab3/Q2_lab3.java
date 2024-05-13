/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package q2_lab3;

import java.util.*;

public class Q2_lab3 {

    private static List<FullTimeEmployee> fullTimeEmployees = new ArrayList<>();
    private static List<PartTimeEmployee> partTimeEmployees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nEmployee Management Menu");
            System.out.println("1. Add Full-time Employee");
            System.out.println("2. Add Part-time Employee");
            System.out.println("3. Show all Full-time Employees");
            System.out.println("4. Show all Part-time Employees");
            System.out.println("5. Show all Employees");
            System.out.println("6. Search Employee by Id");
            System.out.println("7. Delete Employee by Id");
            System.out.println("8. Edit Employee information by Id");
            System.out.println("9. Search Employee by Payment");
            System.out.println("10. Sort Employees by Age, Payment");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addFullTimeEmployee();
                    break;
                case 2:
                    addPartTimeEmployee();
                    break;
                case 3:
                    showAllFullTimeEmployees();
                    break;
                case 4:
                    showAllPartTimeEmployees();
                    break;
                case 5:
                    showAllEmployees();
                    break;
                case 6:
                    searchEmployeeById();
                    break;
                case 7:
                    deleteEmployeeById();
                    break;
                case 8:
                    editEmployeeById();
                    break;
                case 9:
                    searchEmployeeByPayment();
                    break;
                case 10:
                    sortEmployeesByAgeAndPayment();
                    break;
                case 11:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 11);
    }

    private static void addFullTimeEmployee() {
        System.out.print("Enter the number of full time employee: ");
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            {
                System.out.print("Enter Employee ID " + i + ": ");
                String id = scanner.next();

                System.out.print("Enter FT_Employee Name " + i + ": ");
                String name = scanner.next();

                System.out.print("Enter FT_Employee year of birth " + i + ": ");
                int yearOfBirth = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter FT_Employee address " + i + ": ");
                String address = scanner.next();

                System.out.print("Enter FT_Employee phone " + i + ": ");
                String phone = scanner.next();

                System.out.print("Enter FT_Employee Salary " + i + ": ");
                float salary = scanner.nextFloat();

                FullTimeEmployee ft_employee = new FullTimeEmployee(salary, id, name, yearOfBirth, address, phone);
                fullTimeEmployees.add(ft_employee);
                System.out.println("Full-time Employee added successfully!");
            }
        }
    }

    private static void addPartTimeEmployee() {
        System.out.print("Enter the number of part time employee: ");
        int n = scanner.nextInt();
        for(int i = 1;i <= n;i++) {
            System.out.print("Enter PT_Employee ID " + i + ": ");
            String id = scanner.next();

            System.out.print("Enter PT_Employee Name " + i + ": ");
            String name = scanner.next();

            System.out.print("Enter PT_Employee year of birth " + i + ": ");
            int yearOfBirth = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter PT_Employee address " + i + ": ");
            String address = scanner.next();

            System.out.print("Enter PT_Employee phone " + i + ": ");
            String phone = scanner.next();

            System.out.print("Enter PT_Employee Working Hours " + i + ": ");
            int workingHours = scanner.nextInt();

            System.out.print("Enter PT_Employee Pay Rate " + i + ": ");
            float payRate = scanner.nextFloat();

            PartTimeEmployee pt_employee = new PartTimeEmployee(workingHours, payRate, id, name, yearOfBirth, address, phone);
            partTimeEmployees.add(pt_employee);
            System.out.println("Part-time Employee added successfully!");
        }
    }

    private static void showAllFullTimeEmployees() {
        System.out.println("\nAll Full-time Employees:");
        for (FullTimeEmployee ft_employee : fullTimeEmployees) {
            System.out.println(ft_employee.getInfo());
        }
    }

    private static void showAllPartTimeEmployees() {
        System.out.println("\nAll Part-time Employees:");
        for (PartTimeEmployee pt_employee : partTimeEmployees) {
            System.out.println(pt_employee.getInfo());
        }
    }

    private static void showAllEmployees() {
        System.out.println("\nAll Employees:");
        showAllFullTimeEmployees();
        showAllPartTimeEmployees();
    }

    private static void searchEmployeeById() {
        System.out.print("Enter Employee ID to search: ");
        String id = scanner.next();

        Employee find = null;
        for (FullTimeEmployee ft_employee : fullTimeEmployees) {
            if (ft_employee.getId().equals(id)) {
                find = ft_employee;
                break;
            }
        }
        if (find == null) {
            for (PartTimeEmployee pt_employee : partTimeEmployees) {
                if (pt_employee.getId().equals(id)) {
                    find = pt_employee;
                    break;
                }
            }
        }

        if (find != null) {
            System.out.println("Employee found:");
            System.out.println(find.getInfo());
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    private static void deleteEmployeeById() {
        System.out.print("Enter Employee ID to delete: ");
        String id = scanner.next();

        boolean found = false;
        for (Iterator<FullTimeEmployee> iterator = fullTimeEmployees.iterator(); iterator.hasNext();) {
            FullTimeEmployee ft_employee = iterator.next();
            if (ft_employee.getId().equals(id)) {
                iterator.remove();
                found = true;
                break;
            }
        }
        if (!found) {
            for (Iterator<PartTimeEmployee> iterator = partTimeEmployees.iterator(); iterator.hasNext();) {
                PartTimeEmployee pt_employee = iterator.next();
                if (pt_employee.getId().equals(id)) {
                    iterator.remove();
                    found = true;
                    break;
                }
            }
        }

        if (found) {
            System.out.println("Employee with ID " + id + " deleted successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    private static void editEmployeeById() {
        System.out.print("Enter Employee ID to edit: ");
        String id = scanner.next();

        boolean found = false;
        for (FullTimeEmployee ft_employee : fullTimeEmployees) {
            if (ft_employee.getId().equals(id)) {
                editEmployeeDetails(ft_employee);
                found = true;
                break;
            }
        }
        if (!found) {
            for (PartTimeEmployee pt_employee : partTimeEmployees) {
                if (pt_employee.getId().equals(id)) {
                    editEmployeeDetails(pt_employee);
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    private static void editEmployeeDetails(Employee employee) {
        System.out.print("Enter new Name: ");
        employee.name = scanner.next();

        System.out.print("Enter new year of birth: ");
        employee.yearOfBirth = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter new address: ");
        employee.address = scanner.next();

        System.out.print("Enter new phone: ");
        employee.phone = scanner.next();
    }

    private static void searchEmployeeByPayment() {
        System.out.print("Enter lower limit of Payment range: ");
        double lowerLimit = scanner.nextDouble();
        System.out.print("Enter upper limit of Payment range: ");
        double upperLimit = scanner.nextDouble();

        System.out.println("Employees within Payment range:");
        boolean found = false;
        for (FullTimeEmployee ft_employee : fullTimeEmployees) {
            if (ft_employee.getPayment() >= lowerLimit && ft_employee.getPayment() <= upperLimit) {
                System.out.println(ft_employee.getInfo());
                found = true;
            }
        }
        for (PartTimeEmployee pt_employee : partTimeEmployees) {
            if (pt_employee.getPayment() >= lowerLimit && pt_employee.getPayment() <= upperLimit) {
                System.out.println(pt_employee.getInfo());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employees found within specified Payment range.");
        }
    }

    private static void sortEmployeesByAgeAndPayment() {
        Collections.sort(fullTimeEmployees, Comparator.comparingInt(Employee::getYearOfBirth).thenComparingDouble(Employee::getPayment));
        Collections.sort(partTimeEmployees, Comparator.comparingInt(Employee::getYearOfBirth).thenComparingDouble(Employee::getPayment));

        System.out.println("Employees sorted by Age, Payment:");
        showAllFullTimeEmployees();
        showAllPartTimeEmployees();
    }
}
