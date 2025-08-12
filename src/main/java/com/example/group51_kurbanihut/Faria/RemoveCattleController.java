package com.example.group51_kurbanihut.Faria;

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

import static com.example.group51_kurbanihut.Faria.CattleModel.cattleList;

public class RemoveCattleController
{
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> cattleIDTableCol;
    @javafx.fxml.FXML
    private TableView<CattleModel> listTableView;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> cattleWeightTableCol;
    @javafx.fxml.FXML
    private Label removeTextLabel;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, Double> cattlePriceTableCol;

    @javafx.fxml.FXML
    public void initialize() {
        cattleIDTableCol.setCellValueFactory(new PropertyValueFactory<>("cattleID"));
        cattleWeightTableCol.setCellValueFactory(new PropertyValueFactory<>("weight"));
        cattlePriceTableCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        listTableView.getItems().addAll(cattleList);
    }

    @javafx.fxml.FXML
    public void handleRemovebutton(ActionEvent actionEvent) {
        CattleModel cattle = listTableView.getSelectionModel().getSelectedItem();
        if (cattle == null) {
            removeTextLabel.setText("No cattle selected yet!");
            return;
        }

        cattleList.remove(cattle);

        listTableView.getItems().clear();
        listTableView.getItems().addAll(cattleList);

        removeTextLabel.setText("Cattle removed!");
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