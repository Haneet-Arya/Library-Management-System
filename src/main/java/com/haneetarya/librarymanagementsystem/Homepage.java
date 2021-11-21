package com.haneetarya.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Homepage implements Initializable {
    @FXML
    public RadioButton issue;
    @FXML
    public RadioButton addBook;
    @FXML
    public RadioButton addStudent;
    @FXML
    public RadioButton submit;
    @FXML
    public Button logout;
    @FXML
    public Button go;
    public Button studentList;
    public Button booklist;
    public Button borrowlist;
    ToggleGroup tg;
    private FXMLLoader root;
    private Stage stage;


    public void submit(ActionEvent actionEvent) {
        RadioButton rb = (RadioButton) tg.getSelectedToggle();
        String sltd = rb.getText();
        if (sltd.equals("Issue Book")){
            root = new FXMLLoader(getClass().getResource("issuebook.fxml"));
            stage = (Stage) (logout.getScene().getWindow());
            try {
                stage.setScene(new Scene(root.load()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.show();
        }else if(sltd.equals("Submit Book")){
            root = new FXMLLoader(getClass().getResource("submitbook.fxml"));
            stage = (Stage) (logout.getScene().getWindow());
            try {
                stage.setScene(new Scene(root.load()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.show();

        }else if(sltd.equals("Add Student")){
            root = new FXMLLoader(getClass().getResource("addstudent.fxml"));
            stage = (Stage) (logout.getScene().getWindow());
            try {
                stage.setScene(new Scene(root.load()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.show();
        }else{
            root = new FXMLLoader(getClass().getResource("addbook.fxml"));
            stage = (Stage) (logout.getScene().getWindow());
            try {
                stage.setScene(new Scene(root.load()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.show();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tg = new ToggleGroup();
        issue.setToggleGroup(tg);
        addBook.setToggleGroup(tg);
        addStudent.setToggleGroup(tg);
        submit.setToggleGroup(tg);
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                root = new FXMLLoader(getClass().getResource("Login.fxml"));
                stage = (Stage) (logout.getScene().getWindow());
                try {
                    stage.setScene(new Scene(root.load()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                db.logOut();
                stage.show();
            }
        });
    }

    public void getBorrowList(ActionEvent actionEvent) {
        root = new FXMLLoader(getClass().getResource("borrowlist.fxml"));
        stage = (Stage) (logout.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    public void getBookList(ActionEvent actionEvent) {
        root = new FXMLLoader(getClass().getResource("booklist.fxml"));
        stage = (Stage) (logout.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    public void getStudentList(ActionEvent actionEvent) {
        root = new FXMLLoader(getClass().getResource("studentlist.fxml"));
        stage = (Stage) (logout.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }
}
