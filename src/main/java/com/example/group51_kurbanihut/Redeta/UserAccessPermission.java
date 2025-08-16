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

public class UserAccessPermission
{
    @javafx.fxml.FXML
    private TableColumn<UserPermissionModel,String> accessLevelTableCol;
    @javafx.fxml.FXML
    private TableColumn<UserPermissionModel,String> userNameTableCol;
    @javafx.fxml.FXML
    private Label warningLabel;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableView<UserPermissionModel> userPermissionTableView;
    @javafx.fxml.FXML
    private ComboBox<String> accessLevelComboBox;

    ArrayList<UserPermissionModel> accessList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        userNameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        accessLevelTableCol.setCellValueFactory(new PropertyValueFactory<>("accessLevel"));

        accessLevelComboBox.getItems().addAll("View Only","Editor","Moderator");

        accessList.add(new UserPermissionModel("Hasan","Editor"));
        accessList.add(new UserPermissionModel("Rahim","View Only"));
        accessList.add(new UserPermissionModel("Farhan","Moderator"));
        accessList.add(new UserPermissionModel("Islam","View Only"));

        userPermissionTableView.getItems().addAll(accessList);

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
    public void updatePermissionOnHandle(ActionEvent actionEvent) {
        UserPermissionModel access = userPermissionTableView.getSelectionModel().getSelectedItem();
        if(accessLevelComboBox.getValue() == null || access == null){
            warningLabel.setText("Please Fill All Info");
            return;
        }
        access.setAccessLevel(accessLevelComboBox.getValue());
        warningLabel.setText("Status Updated");
        userPermissionTableView.refresh();
    }
}