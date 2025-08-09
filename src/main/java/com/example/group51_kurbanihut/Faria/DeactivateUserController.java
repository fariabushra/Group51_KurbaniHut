package com.example.group51_kurbanihut.Faria;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class DeactivateUserController
{
    @javafx.fxml.FXML
    private TableColumn userNameTableCol;
    @javafx.fxml.FXML
    private Label deactiveTextLabel;
    @javafx.fxml.FXML
    private TableColumn fullNameTableCol;
    @javafx.fxml.FXML
    private TableView deactivateUserTableView;
    @javafx.fxml.FXML
    private TableColumn phoneNoTableCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleDeactivateAccountButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleDashboardButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Faria/AccountManager.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}