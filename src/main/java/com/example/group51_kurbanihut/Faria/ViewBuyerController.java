package com.example.group51_kurbanihut.Faria;

import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ViewBuyerController
{
    @javafx.fxml.FXML
    private TableColumn<BuyerModel, String> buyerFullNameTableCol;
    @javafx.fxml.FXML
    private TableView<BuyerModel> buyerTableView;
    @javafx.fxml.FXML
    private TableColumn<BuyerModel, String> buyerPhoneNoTableCol;
    @javafx.fxml.FXML
    private TableColumn<BuyerModel, String> buyerEmailTableCol;
    @javafx.fxml.FXML
    private TableColumn<BuyerModel, String> buyerPasswordTableCol;

    @javafx.fxml.FXML


    public static ArrayList<SellerModel> buyerList = new ArrayList<>();

    public void initialize() {
        buyerFullNameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        buyerPhoneNoTableCol.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        buyerEmailTableCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        buyerPasswordTableCol.setCellValueFactory(new PropertyValueFactory<>("password"));

        buyerList.add(new SellerModel("Niti", "0234567", "niti@gmail", "2345"));
        buyerList.add(new SellerModel("Sadman", "0238567", "sadman@gmail", "2645"));
        buyerList.add(new SellerModel("Nahin", "0234367", "nahin@gmail", "2745"));
        buyerList.add(new SellerModel("Sami", "0334567", "sami@gmail", "2845"));

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