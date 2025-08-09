package com.example.group51_kurbanihut.Redeta;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ViewDeliveryHistoryController
{
    @javafx.fxml.FXML
    private TableColumn cattleIDTableCol;
    @javafx.fxml.FXML
    private TableColumn addressTableCol;
    @javafx.fxml.FXML
    private TableColumn customerNameTableCol;
    @javafx.fxml.FXML
    private TableView deliveryHistoryTableView;
    @javafx.fxml.FXML
    private TableColumn dateTableCol;
    @javafx.fxml.FXML
    private TableColumn statusTableCol;
    @javafx.fxml.FXML
    private Label deliveryHistoryLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnHandle(ActionEvent actionEvent) {
    }
}