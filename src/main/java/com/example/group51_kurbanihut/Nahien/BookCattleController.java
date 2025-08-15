package com.example.group51_kurbanihut.Nahien;

import com.example.group51_kurbanihut.Faria.CattleModel;
import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

import static com.example.group51_kurbanihut.Faria.CattleModel.cattleList;



public class BookCattleController
{
    @javafx.fxml.FXML
    private TextField cattleIdTextField;
    @javafx.fxml.FXML
    private TextArea bookedCattleShow;
    public static ArrayList<CattleModel> bookedCattle = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void bookCattleButton(ActionEvent actionEvent) {
        String idEntered = cattleIdTextField.getText();

        if (idEntered.isEmpty()) {
            bookedCattleShow.appendText("Please enter a cattle ID.\n");
            return;
        }


        for (CattleModel c : cattleList) {
            if (c.getCattleID().equals(idEntered)) {
                bookedCattleShow.setText("The cattle has been booked");
                bookedCattle.add(c);
            }
        }
        cattleIdTextField.clear();

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
}