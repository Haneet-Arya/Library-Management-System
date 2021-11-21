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

public class Booklist implements Initializable {
    public Label back;
    public TableView<Book> bookTable;
    public TableColumn<Book,Integer> bookid;
    public TableColumn<Book, String> bookname;
    public Button addbook;
    public TableColumn<Book,String> publisher;
    public TableColumn<Book,String> author;
    private ObservableList<Book> list = FXCollections.observableArrayList();
    private FXMLLoader root;
    private Stage stage;

    public void backToHome(MouseEvent mouseEvent) {
        root = new FXMLLoader(getClass().getResource("homepage.fxml"));
        stage = (Stage) (addbook.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    public void addBook(ActionEvent actionEvent) {
        root = new FXMLLoader(getClass().getResource("addbook.fxml"));
        stage = (Stage) (addbook.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bookid.setCellValueFactory(new PropertyValueFactory<>("id"));
        bookname.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));

        list = db.bookList();
        bookTable.setItems(list);

    }
}
