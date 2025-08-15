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

public class DeleteSolveFeedbackController
{
    @javafx.fxml.FXML
    private TableView<Feedback> solvedFeedbackTable;
    @javafx.fxml.FXML
    private TableColumn<Feedback,String> solvedFeedbackColumn;
    @javafx.fxml.FXML
    private Label label;

    @javafx.fxml.FXML
    public void initialize() {
        solvedFeedbackColumn.setCellValueFactory(new PropertyValueFactory<>("massage"));
        solvedFeedbackTable.getItems().addAll(solveList);
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
    public void deleteFeedbackButton(ActionEvent actionEvent) {
        Feedback c= solvedFeedbackTable.getSelectionModel().getSelectedItem();
        if (c == null) {
            label.setText("Select a massage");
            return;
        }
        solveList.remove(c);
        feedbackList.remove(c);
        solvedFeedbackTable.getItems().clear();
        solvedFeedbackTable.getItems().addAll(solveList);
        label.setText("Success");

    }
}