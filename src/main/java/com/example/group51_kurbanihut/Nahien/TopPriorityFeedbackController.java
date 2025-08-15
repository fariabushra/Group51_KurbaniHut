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
import static com.example.group51_kurbanihut.Nahien.Feedback.solveList;

public class TopPriorityFeedbackController
{
    @javafx.fxml.FXML
    private Label titleLabel;
    @javafx.fxml.FXML
    private TableView<Feedback> feedbackTable;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> feedbackCol;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> idCol;
    @javafx.fxml.FXML
    private Label label;

    @javafx.fxml.FXML
    public void initialize() {
        feedbackCol.setCellValueFactory(new PropertyValueFactory<>("massage"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        feedbackTable.getItems().addAll(feedbackList);
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

    @javafx.fxml.FXML
    public void markTopPriorityButton(ActionEvent actionEvent) {
        if(feedbackTable.getItems().isEmpty()){
            return;
        }
        Feedback c=feedbackTable.getSelectionModel().getSelectedItem();
        if(c == null){
            label.setText("Select a message from the table");
            return;
        }
        else {
            label.setText("Marked as Top Priority");
        }
    }
}