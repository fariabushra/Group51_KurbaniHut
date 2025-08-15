package com.example.group51_kurbanihut.Nahien;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.Nahien.Reminder.reminderList;

public class PaymentReminderController
{
    @javafx.fxml.FXML
    private TextField reminderMessageTextField;
    @javafx.fxml.FXML
    private TableColumn<Reminder,String> paymentSatusColumn;
    @javafx.fxml.FXML
    private TableColumn<Reminder,String> buyerIdColumn;
    @javafx.fxml.FXML
    private TableView<Reminder> tableColumn;
    @javafx.fxml.FXML
    private Label label;

    @javafx.fxml.FXML
    public void initialize() {
        paymentSatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        buyerIdColumn.setCellValueFactory(new PropertyValueFactory<>("buyerId"));
        reminderList.add(new Reminder("0001","unpaid"));
        reminderList.add(new Reminder("0002","unpaid"));
        reminderList.add(new Reminder("0003","unpaid"));
        tableColumn.getItems().addAll(reminderList);
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
    public void replySendButton(ActionEvent actionEvent) {
        if(reminderMessageTextField.getText().isEmpty()){
            return;
        }
        Reminder c= tableColumn.getSelectionModel().getSelectedItem();
        if (c == null) {
            return;
        }
        reminderList.remove(c);
        label.setText("Message sent!");
        reminderMessageTextField.clear();

    }
}