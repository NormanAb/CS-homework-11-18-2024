package com.example.books.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Author {
    private final SimpleIntegerProperty id = new SimpleIntegerProperty();

    private SimpleStringProperty firstName = new SimpleStringProperty();
    private SimpleStringProperty lastName = new SimpleStringProperty();
    private SimpleStringProperty email = new SimpleStringProperty();
    private SimpleStringProperty nickName = new SimpleStringProperty();



    public Author(String firstName, String lastName, String email) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.email.set(email);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public String getNickName() {
        return nickName.get();
    }

    public SimpleStringProperty nickNameProperty() {
        return nickName;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setNickName(String nickName) {
        this.nickName.set(nickName);
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + ")";
    }
}
