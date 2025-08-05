module com.example.group51_kurbanihut {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.group51_kurbanihut to javafx.fxml;
    opens com.example.group51_kurbanihut.Faria to javafx.fxml;
    opens com.example.group51_kurbanihut.Nahien to javafx.fxml;
    opens com.example.group51_kurbanihut.Redeta to javafx.fxml;

    exports com.example.group51_kurbanihut;
    exports com.example.group51_kurbanihut.Faria;
    exports com.example.group51_kurbanihut.Nahien;
    exports com.example.group51_kurbanihut.Redeta;
}