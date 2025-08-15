package com.example.group51_kurbanihut.Nahien;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.Nahien.Feedback.feedbackList;
import static com.example.group51_kurbanihut.Nahien.Feedback.solveList;

public class MarkFeedbackSolveController
{
    @javafx.fxml.FXML
    private TableColumn<Feedback,String> feedbackColumn;
    @javafx.fxml.FXML
    private TableView<Feedback> feedbackTable;
    @javafx.fxml.FXML
    private Label titleLabel;
    @javafx.fxml.FXML
    private TableColumn<Feedback,String> idCol;
    @javafx.fxml.FXML
    private Label label;



    @javafx.fxml.FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        feedbackColumn.setCellValueFactory(new PropertyValueFactory<>("massage"));
        feedbackTable.getItems().addAll(feedbackList);
    }

    @javafx.fxml.FXML
    public void solveFeedbackButton(ActionEvent actionEvent) {
        if(feedbackTable.getItems().isEmpty()){
            return;
        }
        Feedback c=feedbackTable.getSelectionModel().getSelectedItem();
        if(c == null){
            label.setText("Select a message from the table");
            return;
        }
        else {
            label.setText("Success");
            solveList.add(c);

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