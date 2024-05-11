/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package q2_lab3;

import java.util.*;

public class Q2_lab3 {

    /**
     * @param args the command line arguments
     */
    private static List<Employee> fullTimeEmployees = new ArrayList<>();
    private static List<Employee> partTimeEmployees = new ArrayList<>();
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
        while (n-- > 0) {
            System.out.print("Enter Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter FT_Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter FT_Employee year of birth: ");
            int yearOfBirth = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter FT_Employee address: ");
            String address = scanner.nextLine();

            System.out.print("Enter FT_Employee phone: ");
            String phone = scanner.nextLine();

            System.out.print("Enter FT_Employee Salary: ");
            double salary = scanner.nextDouble();

            Employee employee = new FullTimeEmployee(id, name, yearOfBirth, address, phone, salary);
            fullTimeEmployees.add(employee);
            System.out.println("Full-time Employee added successfully!");
        }
    }

    private static void addPartTimeEmployee() {
        System.out.print("Enter the number of part time employee: ");
        int n = scanner.nextInt();
        while (n-- > 0) {
            System.out.print("Enter PT_Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter PT_Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter PT_Employee year of birth: ");
            int yearOfBirth = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter PT_Employee address: ");
            String address = scanner.nextLine();

            System.out.print("Enter PT_Employee phone: ");
            String phone = scanner.nextLine();

            System.out.print("Enter PT_Employee Working Hours: ");
            int workingHours = scanner.nextInt();

            System.out.print("Enter PT_Employee Pay Rate: ");
            double payRate = scanner.nextDouble();

            Employee employee = new PartTimeEmployee(id, name, yearOfBirth, address, phone, workingHours, payRate);
            partTimeEmployees.add(employee);
            System.out.println("Part-time Employee added successfully!");
        }
    }

    private static void showAllFullTimeEmployees() {
        System.out.println("\nAll Full-time Employees:");
        for (Employee employee : fullTimeEmployees) {
            System.out.println(employee);
        }
    }

    private static void showAllPartTimeEmployees() {
        System.out.println("\nAll Part-time Employees:");
        for (Employee employee : partTimeEmployees) {
            System.out.println(employee);
        }
    }

    private static void showAllEmployees() {
        System.out.println("\nAll Employees:");
        System.out.println("Full-time Employees:");
        showAllFullTimeEmployees();
        System.out.println("Part-time Employees:");
        showAllPartTimeEmployees();
    }

    private static void searchEmployeeById() {
        System.out.print("Enter Employee ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Employee find = null;
        for (Employee employee : fullTimeEmployees) {
            if (employee.getId().equals(id)) {
                find = employee;
                break;
            }
        }
        if (find == null) {
            for (Employee employee : partTimeEmployees) {
                if (employee.getId().equals(id)) {
                    find = employee;
                    break;
                }
            }
        }

        if (find != null) {
            System.out.println("Employee found:");
            System.out.println(find);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    private static void deleteEmployeeById() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean found = false;
        for (Iterator<Employee> iterator = fullTimeEmployees.iterator(); iterator.hasNext();) {
            Employee employee = iterator.next();
            if (employee.getId().equals(id)) {
                iterator.remove();
                found = true;
                break;
            }
        }
        if (!found) {
            for (Iterator<Employee> iterator = partTimeEmployees.iterator(); iterator.hasNext();) {
                Employee employee = iterator.next();
                if (employee.getId().equals(id)) {
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
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean found = false;
        for (Employee employee : fullTimeEmployees) {
            if (employee.getId().equals(id)) {
                editEmployeeDetails(employee);
                found = true;
                break;
            }
        }
        if (!found) {
            for (Employee employee : partTimeEmployees) {
                if (employee.getId().equals(id)) {
                    editEmployeeDetails(employee);
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
        employee.name = scanner.nextLine();

        System.out.print("Enter new year of birth: ");
        employee.yearOfBirth = scanner.nextInt();

        System.out.print("Enter new address: ");
        employee.address = scanner.nextLine();

        System.out.print("Enter new phone: ");
        employee.phone = scanner.nextLine();
    }

    private static void searchEmployeeByPayment() {
        System.out.print("Enter lower limit of Payment range: ");
        double lowerLimit = scanner.nextDouble();
        System.out.print("Enter upper limit of Payment range: ");
        double upperLimit = scanner.nextDouble();

        System.out.println("Employees within Payment range:");
        boolean found = false;
        for (Employee employee : fullTimeEmployees) {
            if (employee.getPayment() >= lowerLimit && employee.getPayment() <= upperLimit) {
                System.out.println(employee);
                found = true;
            }
        }
        for (Employee employee : partTimeEmployees) {
            if (employee.getPayment() >= lowerLimit && employee.getPayment() <= upperLimit) {
                System.out.println(employee);
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
        System.out.println("Full-time Employees:");
        showAllFullTimeEmployees();
        System.out.println("Part-time Employees:");
        showAllPartTimeEmployees();
    }
}
