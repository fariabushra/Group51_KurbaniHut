package com.example.group51_kurbanihut.Nahien;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SearchCattleController
{
    @javafx.fxml.FXML
    private TableColumn<Cattle,String> cattleNameTableCol;
    @javafx.fxml.FXML
    private TableView<String> cattleTableCol;
    @javafx.fxml.FXML
    private TableColumn<Cattle,String > cattleIdTableCol;
    @javafx.fxml.FXML
    private TableColumn<Cattle, Double> cattlePriceTableCol;
    @javafx.fxml.FXML
    private ComboBox<String> cowGoatComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        cowGoatComboBox.getItems().addAll("Cow", "Goat");

        cattleNameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        cattleIdTableCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        cattlePriceTableCol.setCellValueFactory(new PropertyValueFactory<>("price"));


    }


    @javafx.fxml.FXML
    public void previousButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Nahien/BuyerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}