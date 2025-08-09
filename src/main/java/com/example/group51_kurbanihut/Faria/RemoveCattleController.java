package com.example.group51_kurbanihut.Faria;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class RemoveCattleController
{
    @javafx.fxml.FXML
    private TableColumn cattleHealthStatusTableCol;
    @javafx.fxml.FXML
    private TableColumn cattleIDTableCol;
    @javafx.fxml.FXML
    private TableView listTableView;
    @javafx.fxml.FXML
    private TableColumn cattleWeightTableCol;
    @javafx.fxml.FXML
    private TableColumn cattleHeightTableCol;
    @javafx.fxml.FXML
    private TableColumn cattleColourTableView;
    @javafx.fxml.FXML
    private Label removeTextLabel;
    @javafx.fxml.FXML
    private TableColumn cattleAgeTableCol;
    @javafx.fxml.FXML
    private TableColumn cattlePriceTableCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleRemovebutton(ActionEvent actionEvent) {
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