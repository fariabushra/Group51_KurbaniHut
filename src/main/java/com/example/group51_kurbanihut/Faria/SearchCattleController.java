package com.example.group51_kurbanihut.Faria;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.Faria.CattleModel.cattleList;

public class SearchCattleController
{
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> cattleIDTableCol;
    @javafx.fxml.FXML
    private TextField searchBarTextField;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> weightTableView;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> healthTableView;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> heightTableView;
    @javafx.fxml.FXML
    private TableView<CattleModel> searchListTableView;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> ageTableView;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> colourTableView;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, Double> priceTableView;
    @javafx.fxml.FXML
    private Label searchTextLabel;

    @javafx.fxml.FXML
    public void initialize() {
        cattleIDTableCol.setCellValueFactory(new PropertyValueFactory<>("cattleID"));
        colourTableView.setCellValueFactory(new PropertyValueFactory<>("colour"));
        ageTableView.setCellValueFactory(new PropertyValueFactory<>("age"));
        weightTableView.setCellValueFactory(new PropertyValueFactory<>("weight"));
        heightTableView.setCellValueFactory(new PropertyValueFactory<>("height"));
        priceTableView.setCellValueFactory(new PropertyValueFactory<>("price"));
        healthTableView.setCellValueFactory(new PropertyValueFactory<>("healthStatus"));

        searchListTableView.getItems().addAll(cattleList);
    }

    @javafx.fxml.FXML
    public void handleSearchButton(ActionEvent actionEvent) {
        searchTextLabel.setText("");
        searchListTableView.getItems().clear();
        for (CattleModel search: cattleList){
            if (search.getCattleID().equals(searchBarTextField.getText())){
                searchListTableView.getItems().add(search);
            }


        }
        if (searchListTableView.getItems().isEmpty()){
            searchTextLabel.setText("Cattle ID not matched!");
            return;
        }
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