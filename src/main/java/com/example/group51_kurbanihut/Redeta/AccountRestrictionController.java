package com.example.group51_kurbanihut.Redeta;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

import static com.example.group51_kurbanihut.Redeta.ViewDeliveryModel.DeliveryList;

public class AccountRestrictionController
{
    @javafx.fxml.FXML
    private TableView<AccountRestrictionModel> accountRestrictionTableview;
    @javafx.fxml.FXML
    private TableColumn<AccountRestrictionModel,String> nameTableCol;
    @javafx.fxml.FXML
    private TableColumn<AccountRestrictionModel,String> roleTableCol;
    @javafx.fxml.FXML
    private Label warningLabel;
    @javafx.fxml.FXML
    private Label accountRestrictionLabel;

    ArrayList<AccountRestrictionModel> RestrictionList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        nameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        roleTableCol.setCellValueFactory(new PropertyValueFactory<>("role"));

        RestrictionList.add(new AccountRestrictionModel("Farhan","Seller"));
        RestrictionList.add(new AccountRestrictionModel("Hasan","Delivery Man"));
        RestrictionList.add(new AccountRestrictionModel("Ahmed","Buyer"));
        RestrictionList.add(new AccountRestrictionModel("Islam","Account Manager"));

        accountRestrictionTableview.getItems().addAll(RestrictionList);

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
    public void restrictOnHandle(ActionEvent actionEvent) {
        AccountRestrictionModel clear = accountRestrictionTableview.getSelectionModel().getSelectedItem();
        if(clear == null){
            warningLabel.setText("No User Found");
            return;
        }
        RestrictionList.remove(clear);
        accountRestrictionTableview.getItems().clear();
        accountRestrictionTableview.getItems().addAll(RestrictionList);
        warningLabel.setText("User is Restricted");

    }
}