package com.example.group51_kurbanihut.Redeta;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ClearDataController
{
    @javafx.fxml.FXML
    private TableColumn<ClearDataModel,String> nameTableCol;
    @javafx.fxml.FXML
    private TableColumn<ClearDataModel,String>roleTableCol;
    @javafx.fxml.FXML
    private TableView<ClearDataModel> clearDataTableView;
    @javafx.fxml.FXML
    private TableColumn<ClearDataModel,String> idTableCol;
    @javafx.fxml.FXML
    private Label confirmationMessageLabel;
    @javafx.fxml.FXML
    private Label removeDataLabel;

    private ArrayList<ClearDataModel> ClearDataList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        nameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        roleTableCol.setCellValueFactory(new PropertyValueFactory<>("role"));
        idTableCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        ClearDataList.add(new ClearDataModel("Farhan","123","Seller"));
        ClearDataList.add(new ClearDataModel("Hasan","245","Delivery Man"));
        ClearDataList.add(new ClearDataModel("Ahmed","987","Buyer"));
        ClearDataList.add(new ClearDataModel("Islam","456","Account Manager"));

        clearDataTableView.getItems().addAll(ClearDataList);
    }

    @javafx.fxml.FXML
    public void clearDataOnHandle(ActionEvent actionEvent) {
        ClearDataModel clear = clearDataTableView.getSelectionModel().getSelectedItem();
        if(clear == null){
            confirmationMessageLabel.setText("None is Found");
            return;
        }
        ClearDataList.remove(clear);
        clearDataTableView.getItems().clear();
        clearDataTableView.getItems().addAll(ClearDataList);
        confirmationMessageLabel.setText("Data Removed");


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