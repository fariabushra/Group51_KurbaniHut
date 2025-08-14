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

public class ViewEntryLogsController
{
    @javafx.fxml.FXML
    private TableColumn<EntryLogsModel,String> nameTableCol;
    @javafx.fxml.FXML
    private TableColumn<EntryLogsModel,String> roleTableCol;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> roleComboBox;
    @javafx.fxml.FXML
    private Label warningLabel;
    @javafx.fxml.FXML
    private TableView<EntryLogsModel> entryLogsTableView;
    @javafx.fxml.FXML
    private Label entryLogsLabel;
    @javafx.fxml.FXML
    private TableColumn<EntryLogsModel,String> dateTableCol;

    ArrayList<EntryLogsModel> EntryLogsList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        nameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        roleTableCol.setCellValueFactory(new PropertyValueFactory<>("role"));
        dateTableCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        roleComboBox.getItems().addAll("Buyer","Seller","Delivery Man","Visitor");

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
    public void submitOnHandle(ActionEvent actionEvent) {
        if((nameTextField.getText().isEmpty()) || (roleComboBox.getValue() == null) ||  (dateDatePicker.getValue() == null)){
            warningLabel.setText("Please fill all info");
            return;
        }
        EntryLogsModel entry = new EntryLogsModel (
                nameTextField.getText(),
                roleComboBox.getValue(),
                dateDatePicker.getValue()
        );

        entryLogsTableView.getItems().clear();
        EntryLogsList.add(entry);
        entryLogsTableView.getItems().addAll(EntryLogsList);
        warningLabel.setText("Entry Logs Submitted");

    }
}