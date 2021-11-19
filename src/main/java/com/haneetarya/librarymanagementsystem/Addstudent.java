package com.haneetarya.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Addstudent {
    @FXML
    public Label back;
    @FXML
    public TextField name;
    @FXML
    public TextField phone;
    @FXML
    public Button submit;
    @FXML
    public Label message;
    private FXMLLoader root;
    private Stage stage;
    public void backToHome(MouseEvent mouseEvent) {
        root = new FXMLLoader(getClass().getResource("homepage.fxml"));
        stage = (Stage) (message.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    public void submit(ActionEvent actionEvent) {
        String nam = name.getText();
        String phon = phone.getText();
        if(!nam.equals("") && !phon.equals("")){
            if(db.inserStudent(nam, phon)){
                message.setText("Student Added");
            }
            else {
                message.setText("Database Error");
            }
        }
        else {
            message.setText("Please Enter the correct Name and Phone Number");
        }
    }
}
