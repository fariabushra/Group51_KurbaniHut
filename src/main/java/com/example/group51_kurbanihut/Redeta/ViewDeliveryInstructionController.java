package com.example.group51_kurbanihut.Redeta;

import com.example.group51_kurbanihut.Faria.SellerModel;
import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
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


        try {
            File f = new File("Data/DeliveryMan.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new ObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f, true);
                oos = new ObjectOutputStream(fos);
            }
            for (ViewInstructionModel a : instructionList) {
                oos.writeObject(a);
            }
            oos.close();
        } catch (Exception e){
        }

        viewInstructionsTableView.getItems().addAll(instructionList);


        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File f = new File("Data/DeliveryMan.bin");
            if (f.exists()) {
                fis = new FileInputStream(f);

            } else {
                Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
                erroralert.setContentText("Bin File does not exist.");
                erroralert.show();
            }
            if (fis != null) {
                ois = new ObjectInputStream(fis);
            }
            while (true) {
                viewInstructionsTableView.getItems().addAll((ViewInstructionModel) ois.readObject());
            }
        } catch (Exception e) {
            try {
                if (ois != null) ois.close();
            } catch (Exception e2) {
            }
        }
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