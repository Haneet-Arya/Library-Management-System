module com.haneetarya.librarymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.haneetarya.librarymanagementsystem to javafx.fxml;
    exports com.haneetarya.librarymanagementsystem;
}