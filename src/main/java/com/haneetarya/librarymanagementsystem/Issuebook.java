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

public class Issuebook {
    @FXML
    public TextField studentid;
    @FXML
    public Button issuebook;
    @FXML
    public TextField bookid;
    @FXML
    public Label back;
    public Label message;
    private FXMLLoader root;
    private Stage stage;

    public void backToHome(MouseEvent mouseEvent) {
        root = new FXMLLoader(getClass().getResource("homepage.fxml"));
        stage = (Stage) (issuebook.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    public void issueBook(ActionEvent actionEvent) {
        String sid = studentid.getText();
        String bid = bookid.getText();
        if(!sid.equals("") && !bid.equals("")){
            String ins = db.issueBook(sid,bid);

            if(!ins.equals(db.FALSE)){
                message.setText(ins);
            }
            else {
                message.setText("Database Error");
            }
        }
        else {
            message.setText("Please Enter the correct Name and Phone Number");
        }
    }

    public void newBook(ActionEvent actionEvent) {
        root = new FXMLLoader(getClass().getResource("addbook.fxml"));
        stage = (Stage) (message.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }
}
