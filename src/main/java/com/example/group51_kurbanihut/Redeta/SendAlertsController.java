package com.example.group51_kurbanihut.Redeta;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

import static com.example.group51_kurbanihut.Redeta.ViewDeliveryModel.DeliveryList;

public class SendAlertsController
{
    @javafx.fxml.FXML
    private TableColumn<SendAlertModel,String> nameTableCol;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private Label warningLabel;
    @javafx.fxml.FXML
    private TableColumn<SendAlertModel,String> locationTableCol;
    @javafx.fxml.FXML
    private ComboBox<String> alertTypeCombobox;
    @javafx.fxml.FXML
    private Label emergencyAlertLabel;
    @javafx.fxml.FXML
    private TableView<SendAlertModel> sendAlertsTableView;
    @javafx.fxml.FXML
    private ComboBox<String> locationComboBox;
    @javafx.fxml.FXML
    private TableColumn<SendAlertModel,String> alertTableCol;
    @javafx.fxml.FXML
    private TableColumn<SendAlertModel,String> dateTableCol;

    ArrayList<SendAlertModel> AlertList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        nameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        locationTableCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        alertTableCol.setCellValueFactory(new PropertyValueFactory<>("alertType"));
        dateTableCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        alertTypeCombobox.getItems().addAll("Fire","Theft","First Aid","Weather Alert");
        locationComboBox.getItems().addAll("Entrance","Exist","Gate");

    }

    @javafx.fxml.FXML
    public void backOnHandle(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Redeta/SecurityManager.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void sendAlertOnHandle(ActionEvent actionEvent) {
        if((nameTextField.getText().isEmpty())|| (locationComboBox.getValue() == null) || (alertTypeCombobox.getValue() == null) || (dateDatePicker.getValue() == null)){
            warningLabel.setText("Please fill all info");
            return;
        }
        SendAlertModel Alerts = new SendAlertModel(
                nameTextField.getText(),
                locationComboBox.getValue(),
                alertTypeCombobox.getValue(),
                dateDatePicker.getValue()
        );
        sendAlertsTableView.getItems().clear();
        AlertList.add(Alerts);
        sendAlertsTableView.getItems().addAll(AlertList);
        warningLabel.setText("Alert Send");

    }
}