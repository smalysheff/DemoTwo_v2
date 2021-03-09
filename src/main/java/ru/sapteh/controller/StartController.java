package ru.sapteh.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {

    @FXML
    private Button openProgramBtn;

    @FXML
    private TextField loginLbl;

    @FXML
    private PasswordField passwordLbl;

    @FXML
    public void initialize(){

        openProgramBtn.setOnAction(event -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Authorization");
                stage.setScene(new Scene(root));
                stage.getIcons().add(new Image("/school_logo.png"));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

            ((Button)event.getSource()).getScene().getWindow().hide();
        });
    }

}
