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

public class ViewDeliveryInstructionController
{
    @javafx.fxml.FXML
    private TableColumn<ViewInstructionModel,String> instructionsTableCol;
    @javafx.fxml.FXML
    private TableView<ViewInstructionModel> viewInstructionsTableView;
    @javafx.fxml.FXML
    private TableColumn<ViewInstructionModel,String> addressTableCol;
    @javafx.fxml.FXML
    private TableColumn<ViewInstructionModel,String> customerNameTableCol;
    @javafx.fxml.FXML
    private Label viewInstructionsLabel;

    ArrayList<ViewInstructionModel> instructionList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        customerNameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressTableCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        instructionsTableCol.setCellValueFactory(new PropertyValueFactory<>("instruction"));

        instructionList.add(new ViewInstructionModel("Farhan","Badda","Call Before Arrival"));
        instructionList.add(new ViewInstructionModel("Hasan","Khilgoan","Avoid Front Gate"));
        instructionList.add(new ViewInstructionModel("Ahmed","Rampura","Please Arrive After 6pm"));

        viewInstructionsTableView.getItems().addAll(instructionList);

    }

    @javafx.fxml.FXML
    public void backOnHandle(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Redeta/DeliveryMan.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}