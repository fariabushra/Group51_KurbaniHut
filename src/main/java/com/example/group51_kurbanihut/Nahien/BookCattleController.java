package com.example.group51_kurbanihut.Nahien;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.Nahien.Cattle.cattleList;

public class BookCattleController
{
    @javafx.fxml.FXML
    private TextField cattleIdTextField;
    @javafx.fxml.FXML
    private TextArea bookedCattleShow;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void bookCattleButton(ActionEvent actionEvent) {
        bookedCattleShow.clear();
        for(Cattle x: cattleList){
            if (cattleIdTextField.getText().equals(x.getId())){
                bookedCattleShow.setText(
                        x.getName() + " (ID: " + x.getId()
                );
            }
        }



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