package com.example.group51_kurbanihut.Redeta;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.Redeta.ViewDeliveryModel.DeliveryList;

public class ViewDeliveryHistoryController
{
    @javafx.fxml.FXML
    private TableColumn<ViewDeliveryModel,String> cattleIDTableCol;
    @javafx.fxml.FXML
    private TableColumn<ViewDeliveryModel,String> customerNameTableCol;
    @javafx.fxml.FXML
    private TableView<ViewDeliveryModel> deliveryHistoryTableView;
    @javafx.fxml.FXML
    private TableColumn<ViewDeliveryModel,String> dateTableCol;
    @javafx.fxml.FXML
    private TableColumn<ViewDeliveryModel,String> statusTableCol;
    @javafx.fxml.FXML
    private Label deliveryHistoryLabel;
    @javafx.fxml.FXML
    private TableColumn<ViewDeliveryModel,String> locationTableCol;

    @javafx.fxml.FXML
    public void initialize() {
        customerNameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        locationTableCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        statusTableCol.setCellValueFactory(new PropertyValueFactory<>("deliveryStatus"));
        cattleIDTableCol.setCellValueFactory(new PropertyValueFactory<>("cattleID"));
        dateTableCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        deliveryHistoryTableView.getItems().addAll(DeliveryList);

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
}