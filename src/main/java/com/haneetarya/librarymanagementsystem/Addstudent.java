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
import javax.swing.JOptionPane;

import java.awt.*;
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
            String ins = db.insertStudent(nam, phon);

            if(!ins.equals(db.FALSE)){
                showMessage("Student Added: Student ID is " + ins, "Student Added",JOptionPane.INFORMATION_MESSAGE);


                name.setText("");
                phone.setText("");
            }
            else {
                showMessage("Can't Connect to Database","Database Error",JOptionPane.ERROR_MESSAGE);

            }
        }
        else {
            showMessage("Please Enter the correct Name and Phone Number","Wrong Details",JOptionPane.WARNING_MESSAGE);
//            message.setText("Please Enter the correct Name and Phone Number");
        }
    }
    private void showMessage(String message, String title, int type) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, message,title,type);
            }
        });
    }
}
