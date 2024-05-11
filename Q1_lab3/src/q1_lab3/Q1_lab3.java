/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package q1_lab3;

import java.util.*;

/**
 *
 * @author ASUS
 */
public class Q1_lab3 {

    static List<CD> CD_list = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nCD Store Menu");
            System.out.println("1. Add CD");
            System.out.println("2. Search CD by Title");
            System.out.println("3. Search CDs by Collection");
            System.out.println("4. Search CDs by Type");
            System.out.println("5. Delete CD by ID");
            System.out.println("6. Edit CD information by ID");
            System.out.println("7. Display all CDs");
            System.out.println("8. Sort the CD list by Year of Release");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addCD();
                    break;
                case 2:
                    searchCDByTitle();
                    break;
                case 3:
                    searchCDsByCollection();
                    break;
                case 4:
                    searchCDsByType();
                    break;
                case 5:
                    deleteCDById();
                    break;
                case 6:
                    editCDById();
                    break;
                case 7:
                    displayAllCDs();
                    break;
                case 8:
                    sortCDsByYearOfRelease();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);
    }

    public static void addCD() {
        System.out.println("Enter the numbers of CD you want to add");
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter CD ID " + i  + ": ");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Enter CD Collection (game/movie/music) " + i + ": ");
            String collection = scanner.nextLine();

            System.out.print("Enter CD Type (audio/video) " + i + ": ");
            String type = scanner.nextLine();

            System.out.print("Enter CD Title " + i + ": ");
            String title = scanner.nextLine();

            System.out.print("Enter CD Price " + i + ": ");
            double price = scanner.nextDouble();

            System.out.print("Enter Year of Release " + i + ": ");
            int yearOfRelease = scanner.nextInt();
            
            CD cd = new CD(id, collection, type, title, price, yearOfRelease);
            CD_list.add(cd);
            System.out.println("CD added successfully!");
        }
    }

    static void searchCDByTitle() {
        System.out.print("Enter CD Title to search: ");
        String searchTitle = scanner.nextLine();
        boolean found = false;
        for (CD cd : CD_list) {
            if (cd.getTitle().equalsIgnoreCase(searchTitle)) {
                System.out.println(cd);
                found = true;
            }
        }
        if (!found) {
            System.out.println("CD with title '" + searchTitle + "' not found.");
        }
    }

    static void searchCDsByCollection() {
        System.out.print("Enter CD Collection (game/movie/music) to search: ");
        String searchCollection = scanner.nextLine();
        boolean found = false;
        for (CD cd : CD_list) {
            if (cd.getCollection().equalsIgnoreCase(searchCollection)) {
                System.out.println(cd);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No CDs found for collection '" + searchCollection + "'.");
        }
    }

    static void searchCDsByType() {
        System.out.print("Enter CD Type (audio/video) to search: ");
        String searchType = scanner.nextLine();
        boolean found = false;
        for (CD cd : CD_list) {
            if (cd.getType().equalsIgnoreCase(searchType)) {
                System.out.println(cd);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No CDs found for type '" + searchType + "'.");
        }
    }

    static void deleteCDById() {
        System.out.print("Enter CD ID to delete: ");
        int deleteId = scanner.nextInt();
        boolean found = false;
        Iterator<CD> iterator = CD_list.iterator();
        while (iterator.hasNext()) {
            CD cd = iterator.next();
            if (cd.getId() == deleteId) {
                iterator.remove();
                System.out.println("CD with ID " + deleteId + " deleted successfully.");
                found = true;
            }
        }
        if (!found) {
            System.out.println("CD with ID " + deleteId + " not found.");
        }
    }

    static void editCDById() {
        System.out.print("Enter CD ID to edit: ");
        int editId = scanner.nextInt();
        boolean found = false;
        for (CD cd : CD_list) {
            if (cd.getId() == editId) {
                System.out.println("Current details of CD:");
                System.out.println(cd);

                System.out.println("Enter new CD Collection (game/movie/music): ");
                cd.collection = scanner.nextLine();
                scanner.nextLine();

                System.out.print("Enter new CD Type (audio/video): ");
                cd.type = scanner.nextLine();

                System.out.print("Enter new CD Title: ");
                cd.title = scanner.nextLine();

                System.out.print("Enter new CD Price: ");
                cd.price = scanner.nextDouble();

                System.out.print("Enter new Year of Release: ");
                cd.yearOfRelease = scanner.nextInt();

                System.out.println("CD details updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("CD with ID " + editId + " not found.");
        }
    }

    private static void displayAllCDs() {
        System.out.println("All CDs:");
        for (CD cd : CD_list) {
            System.out.println(cd);
        }
    }

    private static void sortCDsByYearOfRelease() {
        Collections.sort(CD_list, Comparator.comparingInt(CD::getYearOfRelease));
        System.out.println("CDs sorted by Year of Release:");
        displayAllCDs();
    }
}
