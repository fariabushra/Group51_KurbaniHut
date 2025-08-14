package com.example.group51_kurbanihut.Nahien;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AddFavouriteController {
    private static ArrayList<Cattle> favouriteList = new ArrayList<>();

    @javafx.fxml.FXML
    private TextArea favouriteCattleTextArea;

    @javafx.fxml.FXML
    private TextField cattleId;

    @javafx.fxml.FXML
    public void initialize() {
        favouriteCattleTextArea.clear();
    }

    @javafx.fxml.FXML
    public void addCattleFavouriteButton(ActionEvent actionEvent) {
        String idEntered = cattleId.getText();

        if (idEntered.isEmpty()) {
            favouriteCattleTextArea.appendText("Please enter a cattle ID.\n");
            return;
        }

        Cattle found = null;
        for (Cattle c : Cattle.getAllCattle()) {
            if (c.getId().equals(idEntered)) {
                found = c;
                break;
            }
        }

        if (found != null) {
            favouriteList.add(found);
            favouriteCattleTextArea.appendText(
                    found.getName() + " (ID: " + found.getId() + ") added to favourites.\n"
            );
        } else {
            favouriteCattleTextArea.appendText("Cattle ID not found.\n");
        }

        cattleId.clear();
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