package com.example.group51_kurbanihut.Faria;

import com.example.group51_kurbanihut.HelloApplication;
import com.example.group51_kurbanihut.Redeta.ClearDataModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ViewSellerController {
    @javafx.fxml.FXML
    private TableColumn<SellerModel, String> sellerPhoneNoTableCol;
    @javafx.fxml.FXML
    private TableView<SellerModel> viewSellerTableView;
    @javafx.fxml.FXML
    private TableColumn<SellerModel, String> sellerEmailTableCol;
    @javafx.fxml.FXML
    private TableColumn<SellerModel, String> sellerFullNameTableCol;
    @javafx.fxml.FXML
    private TableColumn<SellerModel, String> passwordTableCol;

    @javafx.fxml.FXML

    public static ArrayList<SellerModel> sellerList = new ArrayList<>();

    public void initialize() {
        sellerFullNameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        sellerPhoneNoTableCol.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        sellerEmailTableCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        passwordTableCol.setCellValueFactory(new PropertyValueFactory<>("password"));

       sellerList.add(new SellerModel("Niti", "0234567", "niti@gmail", "2345"));
       sellerList.add(new SellerModel("Sadman", "0238567", "sadman@gmail", "2645"));
       sellerList.add(new SellerModel("Nahin", "0234367", "nahin@gmail", "2745"));
       sellerList.add(new SellerModel("Sami", "0334567", "sami@gmail", "2845"));

        try {
            File f = new File("Data/seller.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new ObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f, true);
                oos = new ObjectOutputStream(fos);
            }
            for (SellerModel a : sellerList) {
                oos.writeObject(a);
            }
            oos.close();
        } catch (Exception e){
}



        viewSellerTableView.getItems().addAll(sellerList);

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File f = new File("Data/seller.bin");
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
                viewSellerTableView.getItems().addAll((SellerModel) ois.readObject());
            }
        } catch (Exception e) {
            try {
                if (ois != null) ois.close();
            } catch (Exception e2) {
       }
}
    }

    @javafx.fxml.FXML
    public void handleDashboardButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Faria/AccountManager.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}