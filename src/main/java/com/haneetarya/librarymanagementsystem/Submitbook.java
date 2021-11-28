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

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Submitbook {
    @FXML
    public Label back;
    @FXML
    public Button submitbook;
    @FXML
    public TextField bookid;
    @FXML
    public TextField studentid;
    @FXML
    public Label message;
    private FXMLLoader root;
    private Stage stage;
    public void backToHome(MouseEvent mouseEvent) {
        root = new FXMLLoader(getClass().getResource("homepage.fxml"));
        stage = (Stage) (submitbook.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    public void submitBook(ActionEvent actionEvent) {
        String sid = studentid.getText();
        String bid = bookid.getText();
        if(!sid.equals("") && !bid.equals("")){
            String ins = db.submitBook(sid,bid);

            if(!ins.equals(db.FALSE)){
                showMessage(ins,"",JOptionPane.INFORMATION_MESSAGE);
//                message.setText(ins);
                bookid.setText("");
                studentid.setText("");
            }
            else {
                showMessage("Can't Connect to Database","Database Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            showMessage("Please Enter the correct Details","Wrong Details",JOptionPane.WARNING_MESSAGE);
//            message.setText("Please Enter the correct Details");
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
