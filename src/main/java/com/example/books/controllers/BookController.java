package com.example.books.controllers;

import com.example.books.models.Author;
import com.example.books.models.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;


public class BookController {
    @FXML
    private TableView<Book> bookTableView;

    @FXML
    private TableColumn<Author, Integer> ISBNColumn;

    @FXML
    private TableColumn<Author, String> bookNameColumn;

    @FXML
    private TableColumn<Author, String> authorNameColumn;

    @FXML
    private TableColumn<Author, Integer> amountColumn;

    @FXML
    private TableColumn<Author, Integer> priceColumn;

    private static ObservableList<Book> books = FXCollections.observableArrayList();

    public void initialize() {

        ISBNColumn.setCellValueFactory(cellData->cellData.getValue().idProperty().asObject());
        bookNameColumn.setCellValueFactory(cellData->cellData.getValue().firstNameProperty());
        authorNameColumn.setCellValueFactory(cellData->cellData.getValue().lastNameProperty());
        amountColumn.setCellValueFactory(cellData->cellData.getValue().emailProperty().length().asObject());
        priceColumn.setCellValueFactory(cellData->cellData.getValue().nickNameProperty().length().asObject());

        bookTableView.setItems(books);
    }

    @FXML
    public void handleAddBook(ActionEvent actionEvent) {

        Dialog<Book> dialog = new Dialog<>();

        dialog.setTitle("Prideti knyga");
        dialog.setHeaderText("Iveskite informacija apie knyga");

        TextField nameField = new TextField();
        TextField authorNameField = new TextField();
        TextField amountField = new TextField();
        TextField priceField = new TextField();


        GridPane grid = new GridPane();

        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Knygos pavadinimas:"), 0, 0);grid.add(nameField, 1, 0);
        grid.add(new Label("Autoriaus vardas:"), 0, 1);grid.add(authorNameField, 1, 1);
        grid.add(new Label("Kiekis:"), 0, 2);grid.add(amountField, 1, 2);
        grid.add(new Label("Kaina:"), 0, 3);grid.add(priceField, 1, 3);

        dialog.getDialogPane().setContent(grid);


        //buttons

        ButtonType addButtonType = new ButtonType("Pridėti", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);

        //handle result
        dialog.setResultConverter(dialogButton ->  {
            if (dialogButton == addButtonType){
                //create Book object
                Book newBook = new Book(nameField.getText(), authorNameField.getText(), amountField.getText(), priceField.getText());
                newBook.setPrice(priceField.getText());
                newBook.setISBN(books.size() + 1);
                return newBook;
            }
            return null;
        });

        Optional<Book> result = dialog.showAndWait();

        result.ifPresent(Book -> {
            books.add(Book);
        });

    }
}
