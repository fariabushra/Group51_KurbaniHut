package com.example.group51_kurbanihut.Redeta;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ViewDeliveriesController
{
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TableView assignedDeliveriesTableView;
    @javafx.fxml.FXML
    private TableColumn addressTableCol;
    @javafx.fxml.FXML
    private TextField customerNameTextField;
    @javafx.fxml.FXML
    private TableColumn dateTableCol;
    @javafx.fxml.FXML
    private ComboBox deliveryStatusComboBox;
    @javafx.fxml.FXML
    private Label assignedDeliveriesLabel;
    @javafx.fxml.FXML
    private TableColumn cattleIDTableCol;
    @javafx.fxml.FXML
    private TableColumn deliveryStatusTableCol;
    @javafx.fxml.FXML
    private TableColumn customerNameTableCol;
    @javafx.fxml.FXML
    private ComboBox cattleIDComboBox;
    @javafx.fxml.FXML
    private TextField locationTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void searchDeliveryOnHandle(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnHandle(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Redeta/DeliveryMan.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void addDeliveryOnHandle(ActionEvent actionEvent) {
    }
}