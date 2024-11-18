package com.example.books.controllers;

import com.example.books.models.Author;
import com.example.books.utils.SceneLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;


public class AuthorController {

    @FXML
    private TableView<Author>  authorTableView;

    @FXML
    private TableColumn<Author, Integer> idColumn;

    @FXML
    private TableColumn<Author, String> firstNameColumn;

    @FXML
    private TableColumn<Author, String> lastNameColumn;

    @FXML
    private TableColumn<Author, String> emailColumn;

    @FXML
    private TableColumn<Author, String> nickNameColumn;

    private static ObservableList<Author> authors = FXCollections.observableArrayList();

    public void initialize() {

        idColumn.setCellValueFactory(cellData->cellData.getValue().idProperty().asObject());
        firstNameColumn.setCellValueFactory(cellData->cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData->cellData.getValue().lastNameProperty());
        emailColumn.setCellValueFactory(cellData->cellData.getValue().emailProperty());
        nickNameColumn.setCellValueFactory(cellData->cellData.getValue().nickNameProperty());

        authorTableView.setItems(authors);
    }

    @FXML
    public void handleAddAuthor(ActionEvent actionEvent) {

        Dialog<Author> dialog = new Dialog<>();

        dialog.setTitle("Prideti autoriu");
        dialog.setHeaderText("Iveskite informacija apie autoriu");

        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField emailField = new TextField();
        TextField nickNameField = new TextField();


        GridPane grid = new GridPane();

        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Vardas:"), 0, 0);grid.add(firstNameField, 1, 0);
        grid.add(new Label("Pavardė:"), 0, 1);grid.add(lastNameField, 1, 1);
        grid.add(new Label("El. paštas:"), 0, 2);grid.add(emailField, 1, 2);
        grid.add(new Label("Slapyvardis:"), 0, 3);grid.add(nickNameField, 1, 3);

        dialog.getDialogPane().setContent(grid);


        //buttons

        ButtonType addButtonType = new ButtonType("Pridėti", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);

        //handle result
        dialog.setResultConverter(dialogButton ->  {
            if (dialogButton == addButtonType){
                //create Author object
                Author newAuthor = new Author(firstNameField.getText(), lastNameField.getText(), emailField.getText());
                newAuthor.setNickName(nickNameField.getText());
                newAuthor.setId(authors.size() + 1);
                return newAuthor;
            }
            return null;
        });

        Optional<Author> result = dialog.showAndWait();

        result.ifPresent(author -> {
            authors.add(author);
        });

    }

}
