package com.example.group51_kurbanihut.Nahien;

import com.example.group51_kurbanihut.Faria.CattleModel;
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

import static com.example.group51_kurbanihut.Faria.CattleModel.cattleList;

public class SearchCattleController
{
    @javafx.fxml.FXML
    private TableView<CattleModel> cattleTableCol;
    @javafx.fxml.FXML
    private TableColumn<CattleModel,String > cattleIdTableCol;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, Double> cattlePriceTableCol;
    @javafx.fxml.FXML
    private ComboBox<String> cowGoatComboBox;

    @javafx.fxml.FXML
    public void initialize() {

        cowGoatComboBox.getItems().addAll("Red", "Black", "White");

        cattleIdTableCol.setCellValueFactory(new PropertyValueFactory<>("cattleID"));
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

    @javafx.fxml.FXML
    public void searchOnClick(ActionEvent actionEvent) {
        if(cowGoatComboBox.getValue()==null){
            return;
        }
        cattleTableCol.getItems().clear();
        for(CattleModel c: cattleList){
            if(c.getColour().equals(cowGoatComboBox.getValue())){
                cattleTableCol.getItems().add(c);
            }
        }
    }
}