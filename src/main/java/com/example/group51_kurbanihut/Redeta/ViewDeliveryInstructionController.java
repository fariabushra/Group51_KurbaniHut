package com.example.group51_kurbanihut.Redeta;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ViewDeliveryInstructionController
{
    @javafx.fxml.FXML
    private TableColumn<ViewDeliveryModel,String> instructionsTableCol;
    @javafx.fxml.FXML
    private TableView<ViewDeliveryModel> viewInstructionsTableView;
    @javafx.fxml.FXML
    private TableColumn<ViewDeliveryModel,String> addressTableCol;
    @javafx.fxml.FXML
    private TableColumn<ViewDeliveryModel,String> customerNameTableCol;
    @javafx.fxml.FXML
    private Label viewInstructionsLabel;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void backOnHandle(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Redeta/DeliveryMan.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}