package com.example.group51_kurbanihut.Redeta;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.Redeta.ViewDeliveryModel.DeliveryList;

public class UpdateDeliveryStatusController
{
    @javafx.fxml.FXML
    private Label updateStatusLabel;
    @javafx.fxml.FXML
    private Label confirmationMessageLabel;
    @javafx.fxml.FXML
    private ComboBox<String> deliveryStatusComboBox;
    @javafx.fxml.FXML
    private TableColumn<ViewDeliveryModel,String> deliveryStatusTableCol;
    @javafx.fxml.FXML
    private TableColumn<ViewDeliveryModel,String> customerNameTableCol;
    @javafx.fxml.FXML
    private TableView<ViewDeliveryModel> updateStatusTableView;

    @javafx.fxml.FXML
    public void initialize() {
        customerNameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        deliveryStatusTableCol.setCellValueFactory(new PropertyValueFactory<>("deliveryStatus"));

        deliveryStatusComboBox.getItems().addAll("Out For Delivery","Delivered","Delivery Failed");
        updateStatusTableView.getItems().addAll(DeliveryList);

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
    public void updateOnHandle(ActionEvent actionEvent) {
        ViewDeliveryModel deliveryS = updateStatusTableView.getSelectionModel().getSelectedItem();
        if(deliveryStatusComboBox.getValue() == null || deliveryS == null){
            confirmationMessageLabel.setText("Please Fill All Info");
            return;
        }
        deliveryS.setDeliveryStatus(deliveryStatusComboBox.getValue());
        confirmationMessageLabel.setText("Status Updated");
        updateStatusTableView.refresh();
    }
}