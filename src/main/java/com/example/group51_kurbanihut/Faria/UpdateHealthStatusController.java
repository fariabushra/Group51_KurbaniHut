package com.example.group51_kurbanihut.Faria;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.Faria.CattleModel.cattleList;

public class UpdateHealthStatusController
{
    @javafx.fxml.FXML
    private Label updateTextLabel;
    @javafx.fxml.FXML
    private ComboBox<String> updateHealthComboBox;
    @javafx.fxml.FXML
    private TableColumn<CattleModel,String> cattleIDTableCol;
    @javafx.fxml.FXML
    private TableColumn<CattleModel,String> healthStatusTableCol;
    @javafx.fxml.FXML
    private TableView<CattleModel> healthStatusTableView;

    @javafx.fxml.FXML
    public void initialize() {
        cattleIDTableCol.setCellValueFactory(new PropertyValueFactory<>("cattleID"));
        healthStatusTableCol.setCellValueFactory(new PropertyValueFactory<>("healthStatus"));

        healthStatusTableView.getItems().addAll(cattleList);
        updateHealthComboBox.getItems().addAll( "Vaccinated", "Healthy", "Under Observation");

    }

    @javafx.fxml.FXML
    public void handleUpdateStatusButton(ActionEvent actionEvent) {
        CattleModel update = healthStatusTableView.getSelectionModel().getSelectedItem();
        if (update == null) {
            updateTextLabel.setText("No cattle selected yet!");
            return;
        }
        update.setHealthStatus(updateHealthComboBox.getValue());

        updateTextLabel.setText("Health status updated!");

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