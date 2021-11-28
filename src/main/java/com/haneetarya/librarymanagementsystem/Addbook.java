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

public class Addbook {
    @FXML
    public TextField bookname;
    @FXML
    public TextField authorname;
    @FXML
    public TextField publisher;
    @FXML
    public Button addbook;
    @FXML
    public Label back;
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

    public void addBook(ActionEvent actionEvent) {
        String nam = bookname.getText();
        String author = authorname.getText();
        String publish = publisher.getText();
        if(!nam.equals("") && !author.equals("") && !publish.equals("")){
            String ins = db.insertBook(nam, author,publish);

            if(!ins.equals(db.FALSE)){
                showMessage("Book Added: Book ID is " + ins, "Student Added",JOptionPane.INFORMATION_MESSAGE);
//                message.setText( + ins);
            }
            else {
                showMessage("Can't Connect to Database","Database Error",JOptionPane.ERROR_MESSAGE);
//                message.setText("Database Error");
            }
        }
        else {
            showMessage("Please Enter the correct Book Name, Author and Publisher","Wrong Details",JOptionPane.WARNING_MESSAGE);

//            message.setText("Please Enter the correct Book Name, Author and Publisher");
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

