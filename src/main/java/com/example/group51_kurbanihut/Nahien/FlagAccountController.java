package com.example.group51_kurbanihut.Nahien;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.Nahien.Feedback.feedbackList;

public class FlagAccountController
{

    @javafx.fxml.FXML
    private TableColumn<Feedback,String> feedbackCol;
    @javafx.fxml.FXML
    private TableView<Feedback> tableCol;
    @javafx.fxml.FXML
    private TableColumn<Feedback,String> idCol;
    @javafx.fxml.FXML
    private Label label;

    @javafx.fxml.FXML
    public void initialize() {
        feedbackCol.setCellValueFactory(new PropertyValueFactory<>("massage"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableCol.getItems().addAll(feedbackList);
    }

    @javafx.fxml.FXML
    public void flagSuspiciousButton(ActionEvent actionEvent) {
        if(tableCol.getItems().isEmpty()){
            return;
        }
        Feedback c = tableCol.getSelectionModel().getSelectedItem();
        if (c == null) {
            label.setText("Select a user from the table");
            return;
        }
        else {
            label.setText("Successfully marked as suspicious!");
        }
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