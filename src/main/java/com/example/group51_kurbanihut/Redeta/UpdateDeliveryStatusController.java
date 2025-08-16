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

import java.util.ArrayList;

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
    private TableColumn<UpdateDeliveryStatusModel,String> deliveryStatusTableCol;
    @javafx.fxml.FXML
    private TableColumn<UpdateDeliveryStatusModel,String> customerNameTableCol;
    @javafx.fxml.FXML
    private TableView<UpdateDeliveryStatusModel> updateStatusTableView;

    ArrayList<UpdateDeliveryStatusModel> statusList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        customerNameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        deliveryStatusTableCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        deliveryStatusComboBox.getItems().addAll("Delivered","Out for delivery","Delivery Failed");

        statusList.add(new UpdateDeliveryStatusModel("Fahim","Delivered"));
        statusList.add(new UpdateDeliveryStatusModel("Islam","Delivery Failed"));
        statusList.add(new UpdateDeliveryStatusModel("Rahman","Out for Delivery"));
        statusList.add(new UpdateDeliveryStatusModel("Hasan","Delivery Failed"));

        updateStatusTableView.getItems().addAll(statusList);

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
       UpdateDeliveryStatusModel deliveryS = updateStatusTableView.getSelectionModel().getSelectedItem();
        if(deliveryStatusComboBox.getValue() == null || deliveryS == null){
            confirmationMessageLabel.setText("Invalid.Please select a valid status");
            return;
        }
        deliveryS.setStatus(deliveryStatusComboBox.getValue());
        confirmationMessageLabel.setText("Delivery status updated successfully");
        updateStatusTableView.refresh();
    }
}