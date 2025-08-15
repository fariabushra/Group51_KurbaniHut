package com.example.group51_kurbanihut.Nahien;

import com.example.group51_kurbanihut.Faria.CattleModel;
import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.Faria.CattleModel.cattleList;
import static com.example.group51_kurbanihut.Nahien.BookCattleController.bookedCattle;

public class PaymentController
{
    @javafx.fxml.FXML
    private ComboBox<String> paymentMethodComboBox;
    @javafx.fxml.FXML
    private TableColumn<CattleModel,String> cattleIdCol;
    @javafx.fxml.FXML
    private TableView<CattleModel> cattleCol;
    @javafx.fxml.FXML
    private TableColumn<CattleModel,Double> cattlePriceCol;
    @javafx.fxml.FXML
    private Label label;

    @javafx.fxml.FXML
    public void initialize() {
        paymentMethodComboBox.getItems().addAll("Bkash","Nagad");

        cattleIdCol.setCellValueFactory(new PropertyValueFactory<>("cattleID"));
        cattlePriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        cattleCol.getItems().addAll(bookedCattle);

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
        if(paymentMethodComboBox.getValue()==null){
            label.setText("Select payment method");
            return;
        }
        CattleModel c=cattleCol.getSelectionModel().getSelectedItem();
        if(c==null){
            return;
        }
        bookedCattle.remove(c);
        label.setText("You have successfully purchased the cattle.");


    }
}