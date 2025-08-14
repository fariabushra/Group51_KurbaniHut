package com.example.group51_kurbanihut.Nahien;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.Nahien.Cattle.cattleList;

public class CattleDetailsController
{
    @javafx.fxml.FXML
    private TableColumn<Cattle, String> cattleNameTableCol;
    @javafx.fxml.FXML
    private TableView<Cattle> cattleDetailsTableCol;
    @javafx.fxml.FXML
    private TableColumn<Cattle, String> cattleIdTableCol;
    @javafx.fxml.FXML
    private TableColumn<Cattle, Double> cattlePriceTableCol;
    @javafx.fxml.FXML
    private TableColumn<Cattle, String> cattleTypeTableCol;
    @javafx.fxml.FXML
    private TableColumn<Cattle,String> statusTableCol;

    @javafx.fxml.FXML
    public void initialize() {
        cattleNameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        cattleIdTableCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        cattleTypeTableCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        cattlePriceTableCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        statusTableCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        cattleDetailsTableCol.getItems().addAll(cattleList);

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