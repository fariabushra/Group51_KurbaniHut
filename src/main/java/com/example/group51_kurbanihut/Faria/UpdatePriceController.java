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

public class UpdatePriceController
{
    @javafx.fxml.FXML
    private Label updateTextLabel;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, Double> priceTableCol;
    @javafx.fxml.FXML
    private TableColumn<CattleModel, String> idTableCol;
    @javafx.fxml.FXML
    private TextField priceUpdateTextField;
    @javafx.fxml.FXML
    private TableView<CattleModel> priceTableView;

    @javafx.fxml.FXML
    public void initialize() {
        idTableCol.setCellValueFactory(new PropertyValueFactory<>("cattleID"));
        priceTableCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        priceTableView.getItems().addAll(cattleList);
    }

    @javafx.fxml.FXML
    public void handleUpdateButton(ActionEvent actionEvent) {
        CattleModel cattle = priceTableView.getSelectionModel().getSelectedItem();
        if (cattle == null){
            updateTextLabel.setText("No cattle added yet!");
            return;

        }
        if (priceUpdateTextField.getText().isEmpty()){
            updateTextLabel.setText("Enter valid price!");
        }
        double newPrice;
        try {
            newPrice = Double.parseDouble(priceUpdateTextField.getText());
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        cattle.setPrice(newPrice);
        priceTableView.getItems().clear();
        priceTableView.getItems().addAll(cattleList);

        updateTextLabel.setText("Price updated!");




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