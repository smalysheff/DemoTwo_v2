package ru.sapteh.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

public class ImageCellView implements Initializable{

    public FlowPane root;

    public ImageView loadedImage;

    public Label bookTitleLbl;

    public Label costLbl;

    public Label isActiveLbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //no-op
    }

    //Метод для удаления старых данных
    public void clear(){
        loadedImage.getImage().cancel();
        loadedImage.setImage(null);
    }

    //Метод для отображения новых данных
    public void update(String url, String title, int isActive, double cost){
        loadedImage.setImage(new Image(url));
        bookTitleLbl.setText(String.format("%s...", title.substring(0, 10)));
        costLbl.setText(String.format("%.2f руб.", cost));
        isActiveLbl.setText(isActive == 0 ? "неактивен" : "");
    }
}
