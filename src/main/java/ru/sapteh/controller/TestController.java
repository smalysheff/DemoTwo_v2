package ru.sapteh.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import ru.sapteh.model.Product;


public class TestController {

    @FXML
    private FlowPane flowPane;

    private final ObservableList<Product> products = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        flowPane.setAlignment(Pos.TOP_LEFT);
        flowPane.setHgap(10);
        flowPane.setVgap(20);

        for (int i = 0; i < 100; i++) {
            Image image = new Image("/school_logo.png");
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            flowPane.getChildren().add(imageView);
        }
    }

    void initData(){

    }

    private Node getNode(String url, String nameBook){
        AnchorPane pane = new AnchorPane();
        Label label = new Label(nameBook);
        Image image = new Image(url);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        pane.getChildren().add(imageView);
        pane.getChildren().add(label);
        return pane;
    }


}
