package ru.sapteh.controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Product;
import ru.sapteh.service.ProductDaoImpl;

import java.io.IOException;
import java.util.List;

public class MainController {

    private final ObservableList<Product> products = createData();

    @FXML
    FlowPane flowPane;


    @FXML
    public void initialize() throws IOException {

        initPane();


        for (Product product : products) {
            String titleBook = product.getTitle();
            flowPane.getChildren().add(getNode(
            product.getMainImagePath(),
                    String.format("%s...", titleBook.substring(0, 10)),
                    String.format("%.2f руб.", product.getCost()),
                    product.getIsActive() == 1
            ));
        }

    }

    private ObservableList<Product> createData(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Dao<Product, Integer> productDaoImpl = new ProductDaoImpl(factory);
        products.addAll(productDaoImpl.findByAll());
        return products;
    }

    private void initPane(){
        flowPane.setAlignment(Pos.TOP_LEFT);
        flowPane.setHgap(20);
        flowPane.setVgap(15);
        flowPane.setPadding(new Insets(10, 10, 10, 10));
    }

    private Node getNode(String url, String title, String cost, boolean isActive){
        ImageView imageView = new ImageView(new Image(url, true));
        imageView.setFitHeight(180);
        imageView.setFitWidth(160);

        Label titleLbl = new Label(title);
        Label costLbl = new Label(cost);
        Label isActiveLbl = new Label("неактивен");

        FlowPane pane = new FlowPane(imageView, titleLbl, costLbl);
        pane.setHgap(10);
        pane.setPadding(new Insets(10));
        pane.setOrientation(Orientation.VERTICAL);
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPrefSize(220, 270);
        pane.setStyle("-fx-border-color: gray");

        if(!isActive) {
            pane.setStyle("-fx-background-color: #cbcaca; -fx-border-color: gray");
            pane.getChildren().add(isActiveLbl);
        }

        return pane;
    }

}
