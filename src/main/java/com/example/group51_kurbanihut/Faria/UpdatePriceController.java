package com.example.group51_kurbanihut.Faria;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdatePriceController
{
    @javafx.fxml.FXML
    private Label updateTextLabel;
    @javafx.fxml.FXML
    private TableColumn priceTableCol;
    @javafx.fxml.FXML
    private TableColumn idTableCol;
    @javafx.fxml.FXML
    private TextField priceUpdateTextField;
    @javafx.fxml.FXML
    private TableView priceTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleUpdateButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleDashboardButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Faria/Seller.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Seller Dashboard");
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}