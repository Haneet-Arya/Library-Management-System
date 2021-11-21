package com.haneetarya.librarymanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Studentlist implements Initializable {
    public Label back;
    public TableColumn<Student, String> id;
    public TableColumn<Student, String> name;
    public TableColumn<Student, String> phoneno;
    public Button addstudent;
    public TableView<Student> studetTable;
    private ObservableList<Student> list = FXCollections.observableArrayList();
    private FXMLLoader root;
    private Stage stage;


    public void backToHome(MouseEvent mouseEvent) {
        root = new FXMLLoader(getClass().getResource("homepage.fxml"));
        stage = (Stage) (addstudent.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }


    public void addStudent(ActionEvent actionEvent) {
        root = new FXMLLoader(getClass().getResource("addstudent.fxml"));
        stage = (Stage) (addstudent.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneno.setCellValueFactory(new PropertyValueFactory<>("phone"));

        list = db.studentList();
        studetTable.setItems(list);
    }
}
