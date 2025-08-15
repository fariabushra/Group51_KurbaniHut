package com.example.group51_kurbanihut.Nahien;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.Nahien.Feedback.feedbackList;

public class FeedbackReplyController
{
    @javafx.fxml.FXML
    private TextArea replyTextArea;
    @javafx.fxml.FXML
    private TableColumn<Feedback,String> feedbackCol;
    @javafx.fxml.FXML
    private TableView<Feedback> tableCol;
    @javafx.fxml.FXML
    private TableColumn<Feedback,String> customerIdcol;
    @javafx.fxml.FXML
    private Label label;

    @javafx.fxml.FXML
    public void initialize() {
        customerIdcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        feedbackCol.setCellValueFactory(new PropertyValueFactory<>("massage"));
        tableCol.getItems().addAll(feedbackList);
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
    public void sendFeedbackButton(ActionEvent actionEvent) {
        Feedback c=tableCol.getSelectionModel().getSelectedItem();
        if (c == null) {
            return;
        }
        if(replyTextArea.getText().isEmpty()){
            label.setText("Type feedback massage");
            return;
        }
        label.setText("Success");
        replyTextArea.clear();

    }
}