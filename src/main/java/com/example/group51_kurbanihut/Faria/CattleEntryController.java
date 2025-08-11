package com.example.group51_kurbanihut.Faria;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.Faria.CattleModel.cattleList;

public class CattleEntryController
{
    @javafx.fxml.FXML
    private TextField cattleWeightTextField;
    @javafx.fxml.FXML
    private TextField cattleAgeTextField;
    @javafx.fxml.FXML
    private TextField priceTextField;
    @javafx.fxml.FXML
    private ComboBox<String> healthStatusComboBox;
    @javafx.fxml.FXML
    private TextField cattleHeightTextField;
    @javafx.fxml.FXML
    private ComboBox<String> cattleColourComboBox;
    @javafx.fxml.FXML
    private Label errorTextField;

    @javafx.fxml.FXML
    public void initialize() {
        healthStatusComboBox.getItems().addAll( "Vaccinated", "Healthy", "Under Observation");
        cattleColourComboBox.getItems().addAll("Red", "Black", "White");

    }

    @javafx.fxml.FXML
    public void handleSubmitButton(ActionEvent actionEvent) {
        if (cattleColourComboBox.getValue()==null){
            errorTextField.setText("Select Colour");
            return;
        }

        else if (healthStatusComboBox.getValue()==null){
            errorTextField.setText("Select Health Status");
            return;
        }

        else if (cattleAgeTextField.getText().isEmpty()){
            errorTextField.setText("Select Cattle Age");
            return;
        }

        else if (cattleWeightTextField.getText().isEmpty()){
            errorTextField.setText("Select Cattle Weight");
            return;
        }

        else if (cattleHeightTextField.getText().isEmpty()){
            errorTextField.setText("Select Cattle Height");

            return;
        }

        else if (priceTextField.getText().isEmpty()){
            errorTextField.setText("Enter Cattle Price");
            return;
        }

        CattleModel cattle = new CattleModel(
                "000" + cattleList.size(),
                cattleAgeTextField.getText(),
                cattleColourComboBox.getValue(),
                cattleWeightTextField.getText(),
                cattleHeightTextField.getText(),
                Double.parseDouble(priceTextField.getText()),
                healthStatusComboBox.getValue()
        );
        cattleList.add(cattle);

        errorTextField.setText("Cattle Submit Successful!");
        System.out.println(cattleList);




    }

    @javafx.fxml.FXML
    public void handleDashboardButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Faria/Seller.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Seller Dashboard");
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}