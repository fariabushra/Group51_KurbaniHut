package com.example.group51_kurbanihut.Redeta;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AccountRestrictionController
{
    @javafx.fxml.FXML
    private TableView accountRestrictionTableview;
    @javafx.fxml.FXML
    private TableColumn nameTableCol;
    @javafx.fxml.FXML
    private TableColumn roleTableCol;
    @javafx.fxml.FXML
    private Label accountRestrictionLabel;
    @javafx.fxml.FXML
    private TextField filteredNameTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void unblockOnHandle(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void blockOnHandle(ActionEvent actionEvent) {
    }
}