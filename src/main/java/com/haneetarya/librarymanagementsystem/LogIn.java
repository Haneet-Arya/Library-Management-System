package com.haneetarya.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class LogIn {
    public Button exit;
    @FXML
    private TextField pwd;
    @FXML
    private Button login;
    @FXML
    private TextField userid;
    @FXML
    private Label failed;

    private Stage stage;
    private Scene scene;
    private FXMLLoader root;

    public void login(ActionEvent actionEvent) {
        if(!userid.getText().equals("") && !pwd.getText().equals("")){
            if(!db.logIn(userid.getText(),pwd.getText())){
                showMessage("Please Check your user ID or Password", JOptionPane.ERROR_MESSAGE );

            }else {
                try {
                    root = new FXMLLoader(getClass().getResource("homepage.fxml"));
                    stage = (Stage) (login.getScene().getWindow());
                    stage.setScene(new Scene(root.load()));
                    stage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            showMessage("Enter the User Id and Password", JOptionPane.WARNING_MESSAGE );
//            failed.setText();
        }
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
    private void showMessage(String message, int type) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, message, "Login Failed",type);
            }
        });
    }
}
