package com.example.group51_kurbanihut.Redeta;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

import static com.example.group51_kurbanihut.Redeta.ViewDeliveryModel.DeliveryList;

public class ReportIssuesController {
    @javafx.fxml.FXML
    private Label confirmationMessageLabel;
    @javafx.fxml.FXML
    private TableColumn<ReportIssueModel, String> nameTableCol;
    @javafx.fxml.FXML
    private ComboBox<String> issueComboBox;
    @javafx.fxml.FXML
    private TableView<ReportIssueModel> reportIssueTableView;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableColumn<ReportIssueModel, String> issueTableCol;
    @javafx.fxml.FXML
    private ComboBox<String> cattleIdCombobox;
    @javafx.fxml.FXML
    private TableColumn<ReportIssueModel, String> cattleIDTableCol;

    ArrayList<ReportIssueModel> IssueList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        nameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        issueTableCol.setCellValueFactory(new PropertyValueFactory<>("issue"));
        cattleIDTableCol.setCellValueFactory(new PropertyValueFactory<>("cattleID"));

        issueComboBox.getItems().addAll("Customer Not Available", "Wrong Address", "Cattle Rejected");
        cattleIdCombobox.getItems().addAll("001", "002", "003", "004");
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
    @javafx.fxml.FXML
    public void submitReportOnHandle(ActionEvent actionEvent) {
        if ((nameTextField.getText().isEmpty()) || (issueComboBox.getValue() == null) || (cattleIdCombobox.getValue() == null)) {
            confirmationMessageLabel.setText("Please fill all info");
            return;
        }
        ReportIssueModel issue = new ReportIssueModel(
                nameTextField.getText(),
                issueComboBox.getValue(),
                cattleIdCombobox.getValue()
        );

        reportIssueTableView.getItems().clear();
        IssueList.add(issue);
        reportIssueTableView.getItems().addAll(IssueList);
        confirmationMessageLabel.setText("Issue Reported");
    }
}
