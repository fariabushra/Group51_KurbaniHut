package com.example.group51_kurbanihut.Redeta;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.Redeta.ViewDeliveryModel.DeliveryList;

public class ViewDeliveriesController
{
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TableView<ViewDeliveryModel> assignedDeliveriesTableView;
    @javafx.fxml.FXML
    private TableColumn<ViewDeliveryModel,String> addressTableCol;
    @javafx.fxml.FXML
    private TextField customerNameTextField;
    @javafx.fxml.FXML
    private TableColumn<ViewDeliveryModel,String> dateTableCol;
    @javafx.fxml.FXML
    private ComboBox<String> deliveryStatusComboBox;
    @javafx.fxml.FXML
    private Label assignedDeliveriesLabel;
    @javafx.fxml.FXML
    private TableColumn<ViewDeliveryModel,String> cattleIDTableCol;
    @javafx.fxml.FXML
    private TableColumn<ViewDeliveryModel,String> deliveryStatusTableCol;
    @javafx.fxml.FXML
    private TableColumn<ViewDeliveryModel,String> customerNameTableCol;
    @javafx.fxml.FXML
    private ComboBox<String> cattleIDComboBox;
    @javafx.fxml.FXML
    private TextField locationTextField;
    @javafx.fxml.FXML
    private Label confirmationLabel;

    @javafx.fxml.FXML
    public void initialize() {
        customerNameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressTableCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        deliveryStatusTableCol.setCellValueFactory(new PropertyValueFactory<>("deliveryStatus"));
        cattleIDTableCol.setCellValueFactory(new PropertyValueFactory<>("cattleID"));
        dateTableCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        deliveryStatusComboBox.getItems().addAll("Out For Delivery","Delivered","Delivery Failed");
        cattleIDComboBox.getItems().addAll("001","002","003","004");

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
        if((customerNameTextField.getText().isEmpty()) || (locationTextField.getText().isEmpty()) || (cattleIDComboBox.getValue() == null) || (deliveryStatusComboBox.getValue() == null) || (dateDatePicker.getValue() == null)){
            confirmationLabel.setText("Please fill all info");
            return;
        }
        ViewDeliveryModel delivery = new ViewDeliveryModel(
                customerNameTextField.getText(),
                locationTextField.getText(),
                deliveryStatusComboBox.getValue(),
                cattleIDComboBox.getValue(),
                dateDatePicker.getValue()
        );
        assignedDeliveriesTableView.getItems().clear();
        DeliveryList.add(delivery);
        assignedDeliveriesTableView.getItems().addAll(DeliveryList);
        confirmationLabel.setText("Delivery Assigned");

    }
}