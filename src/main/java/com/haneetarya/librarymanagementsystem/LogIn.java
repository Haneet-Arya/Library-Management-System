package com.haneetarya.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LogIn {
    @FXML
    public TextField pwd;
    @FXML
    public Button login;
    @FXML
    public TextField userid;
    @FXML
    public Label failed;

    public void login(ActionEvent actionEvent) {
        if(!userid.getText().equals("") && !pwd.getText().equals("")){
            if(!db.logIn(userid.getText(),pwd.getText())){
                failed.setText("Log In failed !!!");
            }
        }
        else {
            failed.setText("Enter the User Id and Password");
        }
    }
}
