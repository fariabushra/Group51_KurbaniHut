package com.example.group51_kurbanihut.Redeta;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class IncidentReportsController
{
    @javafx.fxml.FXML
    private Label incidentReportLabel;
    @javafx.fxml.FXML
    private ComboBox<String> incidentComboBox;
    @javafx.fxml.FXML
    private TextArea descriptionTextArea;
    @javafx.fxml.FXML
    private Label warningLabel;
    @javafx.fxml.FXML
    private TextField timeTextField;
    @javafx.fxml.FXML
    private ComboBox<String> locationComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        incidentComboBox.getItems().addAll("Unauthorized Entry","Emergency Situation","Security Threats","Equipment Damage");
        locationComboBox.getItems().addAll("Entrance","Exist","Gate");
    }

    @javafx.fxml.FXML
    public void backOnHandle(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Redeta/SecurityManager.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void submitReportOnHandle(ActionEvent actionEvent) {

        if ((locationComboBox.getValue() == null || timeTextField.getText().isEmpty() || descriptionTextArea.getText().isEmpty() || incidentComboBox.getValue() == null)) {
            warningLabel.setText("Please fill all the fields");
            return;
        }

        IncidentReportModel incident = new IncidentReportModel(
                locationComboBox.getValue(),
                incidentComboBox.getValue(),
                descriptionTextArea.getText(),
                timeTextField.getText()
        );


        warningLabel.setText("Incident reported successfully and control center notified");
        locationComboBox.getSelectionModel().clearSelection();;
        timeTextField.clear();
        descriptionTextArea.clear();
        incidentComboBox.getSelectionModel().clearSelection();
    }

}