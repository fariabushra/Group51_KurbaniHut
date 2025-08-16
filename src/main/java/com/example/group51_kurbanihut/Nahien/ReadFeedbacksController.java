package com.example.group51_kurbanihut.Nahien;

import com.example.group51_kurbanihut.Faria.SellerModel;
import com.example.group51_kurbanihut.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;

import static com.example.group51_kurbanihut.Nahien.Feedback.feedbackList;

public class ReadFeedbacksController
{
    @javafx.fxml.FXML
    private TextArea feedbackTextArea;
    @javafx.fxml.FXML
    private TableColumn<Feedback,String> feedbackCol;
    @javafx.fxml.FXML
    private TableView<Feedback> tableCol;
    @javafx.fxml.FXML
    private TableColumn<Feedback,String> customerIdcol;

    @javafx.fxml.FXML
    public void initialize() {
        customerIdcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        feedbackCol.setCellValueFactory(new PropertyValueFactory<>("massage"));
        tableCol.getItems().addAll(feedbackList);


        try {
            File f = new File("Data/Feedback.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new ObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f, true);
                oos = new ObjectOutputStream(fos);
            }
            for (Feedback a : feedbackList) {
                oos.writeObject(a);
            }
            oos.close();
        } catch (Exception e) {
        }

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File f = new File("Data/Feedback.bin");
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
                tableCol.getItems().addAll((Feedback) ois.readObject());
            }
        } catch (Exception e) {
            try {
                if (ois != null) ois.close();
            } catch (Exception e2) {
            }
        }

    }

    @javafx.fxml.FXML
    public void previousButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Nahien/CustomerServiceOfficerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void readButton(ActionEvent actionEvent) {
        Feedback c=tableCol.getSelectionModel().getSelectedItem();
        if (c == null) {
            return;
        }
        feedbackTextArea.setText(c.getMassage());
    }
}