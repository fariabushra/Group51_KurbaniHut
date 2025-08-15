package com.example.group51_kurbanihut.Nahien;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.Nahien.Feedback.feedbackList;

public class FeedbackController
{
    @javafx.fxml.FXML
    private TextField feedbackTextField;
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private Label label;

    @javafx.fxml.FXML
    public void initialize() {
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
    public void sendFeedbackButton(ActionEvent actionEvent) {
        if(feedbackTextField.getText().isEmpty()){
            label.setText("Type user id");
            return;
        }
        if(idTextField.getText().isEmpty()){
            label.setText("Type feedback message");
            return;
        }
        Feedback c=new Feedback(idTextField.getText(),feedbackTextField.getText());
        feedbackList.add(c);
        label.setText("Success");
    }

}