package com.haneetarya.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
                failed.setText("Log In failed !!!");
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
            failed.setText("Enter the User Id and Password");
        }
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
