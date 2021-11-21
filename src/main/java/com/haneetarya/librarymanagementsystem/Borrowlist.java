package com.haneetarya.librarymanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Borrowlist implements Initializable {
    public Label back;
    public TableView<Borrow> borrowTable;
    public TableColumn<Borrow,Integer> sid;
    public TableColumn<Borrow,String> sname;
    public TableColumn<Borrow,String> bname;
    public TableColumn<Borrow,String> phoneno;
    public TableColumn<Borrow,String> author;
    public TableColumn<Borrow,String> publisher;
    public TableColumn<Borrow,Integer> bid;
    private ObservableList<Borrow> ls = FXCollections.observableArrayList();
    private FXMLLoader root;
    private Stage stage;
    public void backToHome(MouseEvent mouseEvent) {
        root = new FXMLLoader(getClass().getResource("homepage.fxml"));
        stage = (Stage) (back.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bid.setCellValueFactory(new PropertyValueFactory<>("bid"));
        bname.setCellValueFactory(new PropertyValueFactory<>("bname"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        sid.setCellValueFactory(new PropertyValueFactory<>("sid"));
        sname.setCellValueFactory(new PropertyValueFactory<>("sname"));
        phoneno.setCellValueFactory(new PropertyValueFactory<>("phone"));
        ls = db.borrowList();

        borrowTable.setItems(ls);

    }
}
