package com.example.group51_kurbanihut.Nahien;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.Nahien.Feedback.feedbackList;

public class ReadFeedbacksController
{
    @javafx.fxml.FXML
    private TextArea feedbackTextArea;
    @javafx.fxml.FXML
    private TableColumn<Feedback,String> feedbackCol;
    @javafx.fxml.FXML
    private TableView<Feedback> tableCol;
    @javafx.fxml.FXML
    private TableColumn<Feedback,String> customerIdcol;

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
    public void readButton(ActionEvent actionEvent) {
        Feedback c=tableCol.getSelectionModel().getSelectedItem();
        if (c == null) {
            return;
        }
        feedbackTextArea.setText(c.getMassage());
    }
}