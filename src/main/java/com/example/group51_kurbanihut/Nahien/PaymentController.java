package com.example.group51_kurbanihut.Nahien;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PaymentController
{
    @javafx.fxml.FXML
    private TextArea bookedCattleList;
    @javafx.fxml.FXML
    private TextField cattleId;
    @javafx.fxml.FXML
    private ComboBox<String> paymentMethodComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        paymentMethodComboBox.getItems().addAll("Bkash","Nagad");

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
    public void makePaymentButton(ActionEvent actionEvent) {
        if(cattleId.getText().isEmpty()){
            bookedCattleList.setText("Type cattle Id");
        } else if (paymentMethodComboBox.getValue()==null) {
            bookedCattleList.setText("Choose payment method");
        }

    }
}