package com.example.group51_kurbanihut.Nahien;

import static com.example.group51_kurbanihut.Faria.CattleModel.cattleList;

import com.example.group51_kurbanihut.Faria.CattleModel;
import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class ViewCattleController
{
    @javafx.fxml.FXML
    private TableView<CattleModel> cattleTableCol;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> cattleIdTableCol;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, Double> cattlePriceTableCol;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> cattleColorTableCol;

    @javafx.fxml.FXML
    public void initialize() {

        cattleIdTableCol.setCellValueFactory(new PropertyValueFactory<>("cattleID"));
        cattleColorTableCol.setCellValueFactory(new PropertyValueFactory<>("colour"));
        cattlePriceTableCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        cattleTableCol.getItems().addAll(cattleList);
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