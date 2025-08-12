package com.example.group51_kurbanihut.Redeta;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AccessLogsController
{
    @javafx.fxml.FXML
    private TableColumn<AccessLogsModel,String> nameTableCol;
    @javafx.fxml.FXML
    private Label accessLogsLabel;
    @javafx.fxml.FXML
    private TableView<AccessLogsModel> accessLogsTableView;
    @javafx.fxml.FXML
    private TableColumn<AccessLogsController,String> entryTimeTableCol;
    @javafx.fxml.FXML
    private TableColumn<AccessLogsController,String> locationTableCol;
    @javafx.fxml.FXML
    private ComboBox<String> selectLocationComboBox;
    @javafx.fxml.FXML
    private Label warningLabel;
    @javafx.fxml.FXML
    private TextField timeTextField;

    ArrayList<AccessLogsModel> accessL= new ArrayList<>();

    public AccessLogsController() {
       accessL.add(new AccessLogsModel("Farid","Exist","5pm"));
       accessL.add(new AccessLogsModel("Islam","Entrance","4pm"));
       accessL.add(new AccessLogsModel("Hasan","Gate","4pm"));

    }

    @javafx.fxml.FXML
    public void initialize() {
        nameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        entryTimeTableCol.setCellValueFactory(new PropertyValueFactory<>("entryTime"));
        locationTableCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        selectLocationComboBox.getItems().addAll("Entrance","Exit","Gate");

        updateTable(accessL);


        ArrayList<String> locations = new ArrayList<>();
        for (AccessLogsModel log : accessL) {
            if (!locations.contains(log.getLocation())) {
                locations.add(log.getLocation());
            }
        }
        selectLocationComboBox.getItems().addAll(locations);
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
    public void searchButtonOnAction(ActionEvent actionEvent) {

        String selectedDate = timeTextField.getText();
        String selectedLocation = selectLocationComboBox.getValue();

        ArrayList<AccessLogsModel> filteredLogs = new ArrayList<>();

        for (AccessLogsModel log : accessL) {
            boolean matchesDate = (selectedDate == null) || log.getEntryTime().equals(selectedDate);
            boolean matchesLocation = (selectedLocation == null) || log.getLocation().equalsIgnoreCase(selectedLocation);

            if (matchesDate && matchesLocation) {
                filteredLogs.add(log);
            }
        }


        accessLogsTableView.getItems().clear();
        accessLogsTableView.getItems().addAll(filteredLogs);


        if (filteredLogs.isEmpty()) {
            warningLabel.setText("No records found for the selected filters.");
        } else {
            warningLabel.setText("");
        }
    }
    private void updateTable(ArrayList<AccessLogsModel> logs) {
        accessLogsTableView.getItems().clear();
        accessLogsTableView.getItems().addAll(logs);
    }
}