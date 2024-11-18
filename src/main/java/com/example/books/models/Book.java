package com.example.books.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class Book {
    private final SimpleIntegerProperty ISBN = new SimpleIntegerProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty author = new SimpleStringProperty();
    private SimpleStringProperty amount = new SimpleStringProperty();
    private SimpleStringProperty price = new SimpleStringProperty();

    public Book(String name, String author, String amount, String price) {
        this.name = new SimpleStringProperty(name);
        this.author = new SimpleStringProperty(author);
        this.amount = new SimpleStringProperty(amount);
        this.price = new SimpleStringProperty(price);
    }


    public int getISBN() {
        return ISBN.get();
    }

    public SimpleIntegerProperty ISBNProperty() {
        return ISBN;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getAuthor() {
        return author.get();
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public String getAmount() {
        return amount.get();
    }

    public SimpleStringProperty amountProperty() {
        return amount;
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setISBN(int ISBN) {
        this.ISBN.set(ISBN);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public void setAmount(String amount) {
        this.amount.set(amount);
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    @Override
    public String toString() {
        return getName() + " " + getAuthor() + ")";
    }
}
