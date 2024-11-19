import com.example.compscijavafx20241119.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class MainController {
    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> classColumn;

    @FXML
    private TableColumn<Student, Double> gradeColumn;

    @FXML
    private Button loadFileButton;

    private final ObservableList<Student> studentData = FXCollections.observableArrayList();

    @FXML

    private void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        classColumn.setCellValueFactory(new PropertyValueFactory<>("StudentClass"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
        tableView.setItems(studentData);

        loadFileButton.setOnAction(event -> loadStudentData());

    }

    private void loadStudentData() {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Open student data file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("text files", "*.txt"));
        File file = fileChooser.showOpenDialog(tableView.getScene().getWindow());

        if (file != null) {
            studentData.clear();
            try(){

            }catch(Exception e) {
                System.err.println("Error");
            }
        }
    }



}
