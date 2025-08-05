module com.example.group51_kurbanihut {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.group51_kurbanihut to javafx.fxml;
    exports com.example.group51_kurbanihut;
}