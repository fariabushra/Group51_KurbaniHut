package com.example.group51_kurbanihut.Faria;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ViewCattleListController
{
    @javafx.fxml.FXML
    private TableColumn CattleIDTableCol;
    @javafx.fxml.FXML
    private TableView cattleListTableView;
    @javafx.fxml.FXML
    private TableColumn weightTableCol;
    @javafx.fxml.FXML
    private TableColumn healthStatusTableCol;
    @javafx.fxml.FXML
    private TableColumn heightTableCol;
    @javafx.fxml.FXML
    private TableColumn priceTableCol;
    @javafx.fxml.FXML
    private TableColumn colourTableCol;
    @javafx.fxml.FXML
    private TableColumn ageTableCol;

    @javafx.fxml.FXML
    public void initialize() {
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