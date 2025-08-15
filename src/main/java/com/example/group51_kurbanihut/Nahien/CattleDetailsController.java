package com.example.group51_kurbanihut.Nahien;

import com.example.group51_kurbanihut.Faria.CattleModel;
import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.Faria.CattleModel.cattleList;


public class CattleDetailsController
{
    @javafx.fxml.FXML
    private TableView<CattleModel> cattleDetailsTableCol;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> cattleIdTableCol;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, Double> cattlePriceTableCol;
    @javafx.fxml.FXML
    private TableColumn<CattleModel,String> cattleColourTableCol;
    @javafx.fxml.FXML
    private Label label;

    @javafx.fxml.FXML
    public void initialize() {

        cattleIdTableCol.setCellValueFactory(new PropertyValueFactory<>("cattleID"));
        cattleColourTableCol.setCellValueFactory(new PropertyValueFactory<>("colour"));
        cattlePriceTableCol.setCellValueFactory(new PropertyValueFactory<>("price"));

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

    @javafx.fxml.FXML
    public void checkButton(ActionEvent actionEvent) {
        CattleModel c=cattleDetailsTableCol.getSelectionModel().getSelectedItem();
        if(c==null){
            return;
        }
        label.setText("The weight of the cattle is: "+c.getWeight()+"\nThe height of the cattle is: "+c.getHeight()+"\nThe age of the cattle is: "+c.getAge());
    }
}