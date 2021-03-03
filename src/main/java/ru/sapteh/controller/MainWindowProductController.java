package ru.sapteh.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Product;
import ru.sapteh.service.ProductDaoImpl;

import java.io.IOException;
import java.util.List;

public class MainWindowProductController {

    ObservableList<Product> products = FXCollections.observableArrayList();

    @FXML
    FlowPane flowPane;


    @FXML
    public void initialize(){
        initData();


        flowPane.setAlignment(Pos.TOP_LEFT);
        flowPane.setHgap(20);
        flowPane.setVgap(15);
        flowPane.setPadding(new Insets(10, 10, 10, 10));


        for (Product product : products) {
//            Image image = new Image(product.getMainImagePath());
//            ImageView imageView = new ImageView();
//            imageView.setFitHeight(200);
//            imageView.setFitWidth(150);
//            imageView.setImage(image);
            flowPane.getChildren().add(getNode(product.getMainImagePath()));



        }




    }

    private void initData(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Dao<Product, Integer> productDaoImpl = new ProductDaoImpl(factory);
        products.addAll(productDaoImpl.findByAll());

    }

    private Node getNode(String url){
        ImageView imageView = new ImageView(new Image(url, true));
        imageView.setFitHeight(200);
        imageView.setFitWidth(150);
        Label label = new Label("Hello");
        label.snapPositionX(0);
        label.snapPositionY(60);
        AnchorPane pane = new AnchorPane();
        pane.prefHeight(200);
        pane.prefWidth(150);
        pane.getChildren().add(imageView);
        pane.getChildren().add(label);

        return pane;
    }

}
