package com.example.group51_kurbanihut;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.group51_kurbanihut.SignUpModel.accountHolders;

public class SignUpController
{
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private TextField numberTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private Label signUpLabel;
    @javafx.fxml.FXML
    private PasswordField passwordPassField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void createAccLabel(ActionEvent actionEvent) {
        if((nameTextField.getText().isEmpty()) || emailTextField.getText().isEmpty() || passwordPassField.getText().isEmpty() || numberTextField.getText().isEmpty()){
            confirmationLabel.setText("Please fill all inputs");
            return;
        }

        SignUpModel accountHolder = new SignUpModel(
                nameTextField.getText(),
                passwordPassField.getText(),
                emailTextField.getText(),
                numberTextField.getText()

        );
        accountHolders.add(accountHolder);
        confirmationLabel.setText("Account Created");
    }

    @javafx.fxml.FXML
    public void backOnHandle(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}