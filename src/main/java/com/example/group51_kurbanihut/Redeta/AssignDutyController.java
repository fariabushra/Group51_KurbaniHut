package com.example.group51_kurbanihut.Redeta;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.Redeta.AssignDutyModel.AssignedDutyList;

public class AssignDutyController
{
    @javafx.fxml.FXML
    private TableColumn<AssignDutyModel,String> assignedZoneTableCol;
    @javafx.fxml.FXML
    private ComboBox<String> zoneComboBox;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private Label confirmationMessageLabel;
    @javafx.fxml.FXML
    private TableColumn<AssignDutyModel,String> officerNameTableCol;
    @javafx.fxml.FXML
    private TableView<AssignDutyModel> assignDutyTableView;
    @javafx.fxml.FXML
    private Label assignDutyLabel;

    @javafx.fxml.FXML
    public void initialize() {
        officerNameTableCol.setCellValueFactory(new PropertyValueFactory<>("officerName"));
        assignedZoneTableCol.setCellValueFactory(new PropertyValueFactory<>("assignedZone"));

        zoneComboBox.getItems().addAll("Entrance","Exist","Gate");

    }

    @javafx.fxml.FXML
    public void assignZoneOnHandle(ActionEvent actionEvent) {

        if((nameTextField.getText().isEmpty()) || (zoneComboBox.getValue() == null)){
            confirmationMessageLabel.setText("Please fill all info");
            return;

        }

        AssignDutyModel duties = new AssignDutyModel(
                nameTextField.getText(),
                zoneComboBox.getValue()
        );

        assignDutyTableView.getItems().clear();
        AssignedDutyList.add(duties);
        assignDutyTableView.getItems().addAll(AssignedDutyList);
        confirmationMessageLabel.setText("Zone Assigned");

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
}