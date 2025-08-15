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

import static com.example.group51_kurbanihut.Redeta.ViewDeliveryModel.DeliveryList;

public class UserAccessController
{
    @javafx.fxml.FXML
    private TableColumn<UserAccessPermission,String> nameTableCol;
    @javafx.fxml.FXML
    private TableView<UserAccessPermission> userAccessTableView;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private Label userAccessControlLabel;
    @javafx.fxml.FXML
    private TableColumn<UserAccessPermission,String> accessTableCol;
    @javafx.fxml.FXML
    private ComboBox<String> accesslevelCombobox;

    ArrayList<UserAccessPermission> PermissionList = new ArrayList<>();
    @javafx.fxml.FXML
    private Label warningLabel;

    @javafx.fxml.FXML
    public void initialize() {
        nameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        accessTableCol.setCellValueFactory(new PropertyValueFactory<>("accessLevel"));

        accesslevelCombobox.getItems().addAll("View Only","Editor","Moderator");

        PermissionList.add(new UserAccessPermission("Farhan","View Only"));
        PermissionList.add(new UserAccessPermission("Hasan","Editor"));
        PermissionList.add(new UserAccessPermission("Ahmed","Moderator"));
        PermissionList.add(new UserAccessPermission("Islam","Editor"));

        userAccessTableView.getItems().addAll(PermissionList);
    }

    @javafx.fxml.FXML
    public void updatePermissionOnHandle(ActionEvent actionEvent) {
        UserAccessPermission access = userAccessTableView.getSelectionModel().getSelectedItem();
        if(accesslevelCombobox.getValue() == null || access == null){
            warningLabel.setText("Please Fill All Info");
            return;
        }
        access.setAccessLevel(accesslevelCombobox.getValue());
        warningLabel.setText("Status Updated");
        userAccessTableView.refresh();
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
}
