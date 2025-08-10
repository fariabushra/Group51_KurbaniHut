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

public class LoginController {
    @javafx.fxml.FXML
    private PasswordField passwordTextField;
    @javafx.fxml.FXML
    private Label errorTextField;
    @javafx.fxml.FXML
    private TextField userNameTextfield;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleLoginButton(ActionEvent actionEvent) {
        for (SignUpModel holders:accountHolders){
            if ((userNameTextfield.getText().equals(holders.getName())) && (passwordTextField.getText().equals(holders.getPassword()))){
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewUserDashboard.fxml"));
                    Scene nextScene = new Scene(fxmlLoader.load());
                    Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    nextStage.setScene(nextScene);
                    nextStage.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if ((userNameTextfield.getText().equals("Delivery Man")) && (passwordTextField.getText().equals("1234"))) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Redeta/DeliveryMan.fxml"));
                Scene nextScene = new Scene(fxmlLoader.load());
                Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                nextStage.setTitle(" Delivery Man Dashboard");
                nextStage.setScene(nextScene);
                nextStage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            userNameTextfield.setText("Login Successful");
        } else if ((userNameTextfield.getText().equals("Security Manager")) && (passwordTextField.getText().equals("1234"))) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Redeta/SecurityManager.fxml"));
                Scene nextScene = new Scene(fxmlLoader.load());
                Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                nextStage.setTitle("Security Manager Dashboard");
                nextStage.setScene(nextScene);
                nextStage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if ((userNameTextfield.getText().equals("Seller")) && (passwordTextField.getText().equals("1234"))) {
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
            userNameTextfield.setText("Login Successful");
        } else if ((userNameTextfield.getText().equals("Account Manager")) && (passwordTextField.getText().equals("1234"))) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Faria/AccountManager.fxml"));
                Scene nextScene = new Scene(fxmlLoader.load());
                Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                nextStage.setTitle("Account Manager Dashboard");
                nextStage.setScene(nextScene);
                nextStage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if ((userNameTextfield.getText().equals("Buyer")) && (passwordTextField.getText().equals("1234"))) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Nahien/BuyerDashboard.fxml"));
                Scene nextScene = new Scene(fxmlLoader.load());
                Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                nextStage.setTitle("Buyer Dashboard");
                nextStage.setScene(nextScene);
                nextStage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            userNameTextfield.setText("Login Successful");
        } else if ((userNameTextfield.getText().equals("CSO")) && (passwordTextField.getText().equals("1234"))) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Nahien/CustomerServiceOfficerDashboard.fxml"));
                Scene nextScene = new Scene(fxmlLoader.load());
                Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                nextStage.setTitle("Customer Service Dashboard");
                nextStage.setScene(nextScene);
                nextStage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @javafx.fxml.FXML
    public void signUpOnHandle(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signUp.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}