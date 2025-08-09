package com.example.group51_kurbanihut.Nahien;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class FlagAccountController
{
    @javafx.fxml.FXML
    private TableColumn nameColumn;
    @javafx.fxml.FXML
    private TableView tableColumn;
    @javafx.fxml.FXML
    private TableColumn idColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void flagSuspiciousButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void previousButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Nahien/CustomerServiceOfficerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}