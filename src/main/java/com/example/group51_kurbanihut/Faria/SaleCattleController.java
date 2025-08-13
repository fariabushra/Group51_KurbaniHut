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

import static com.example.group51_kurbanihut.Faria.CattleModel.*;

public class SaleCattleController {
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> cattleIDTableCol;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> weightTableCol;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> priceTableCol;
    @javafx.fxml.FXML
    private Label saleTextLabel;
    @javafx.fxml.FXML
    private TableView<CattleModel> saleCattleTableView;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> colourTableCol;

    @javafx.fxml.FXML
    public void initialize() {
        cattleIDTableCol.setCellValueFactory(new PropertyValueFactory<>("cattleID"));
        colourTableCol.setCellValueFactory(new PropertyValueFactory<>("colour"));
        weightTableCol.setCellValueFactory(new PropertyValueFactory<>("weight"));
        priceTableCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        saleCattleTableView.getItems().addAll(cattleList);
    }

    @javafx.fxml.FXML
    public void handleSaleCattleButton(ActionEvent actionEvent) {
        CattleModel sale = saleCattleTableView.getSelectionModel().getSelectedItem();
        if (sale == null) {
            saleTextLabel.setText("No cattle selected yet!");
            return;
        }
        cattleList.remove(sale);

        saleCattleTableView.getItems().clear();
        saleCattleTableView.getItems().addAll(cattleList);

        saleTextLabel.setText("Cattle Sold!");

        countSales += 1;
        totalPrice += sale.getPrice();

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