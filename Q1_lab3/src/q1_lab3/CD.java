/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1_lab3;

/**
 *
 * @author ASUS
 */
public class CD {
    private int id;
    String collection;
    String type;
    String title;
    double price;
    int yearOfRelease;

    public CD() {
    }

    public CD(int id, String collection, String type, String title, double price, int yearOfRelease) {
        this.id = id;
        this.collection = collection;
        this.type = type;
        this.title = title;
        this.price = price;
        this.yearOfRelease = yearOfRelease;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }
    
    public String toString(){
        return "ID: " + id + ", Collection: " + collection + ", Type: " + type + ", Title: " + title + ", Price: $" + price + ", Year of Release: " + yearOfRelease;
    }
    
}
