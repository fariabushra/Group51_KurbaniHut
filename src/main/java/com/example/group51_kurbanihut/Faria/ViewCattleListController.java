package com.example.group51_kurbanihut.Faria;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.Faria.CattleModel.cattleList;

public class ViewCattleListController
{
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> CattleIDTableCol;
    @javafx.fxml.FXML
    private TableView<CattleModel> cattleListTableView;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> weightTableCol;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> healthStatusTableCol;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> heightTableCol;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, Double> priceTableCol;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> colourTableCol;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> ageTableCol;

    @javafx.fxml.FXML
    public void initialize() {
        CattleIDTableCol.setCellValueFactory(new PropertyValueFactory<>("cattleID"));
        ageTableCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        colourTableCol.setCellValueFactory(new PropertyValueFactory<>("colour"));
        weightTableCol.setCellValueFactory(new PropertyValueFactory<>("weight"));
        heightTableCol.setCellValueFactory(new PropertyValueFactory<>("height"));
        priceTableCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        healthStatusTableCol.setCellValueFactory(new PropertyValueFactory<>("healthStatus"));

        cattleListTableView.getItems().addAll(cattleList);

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