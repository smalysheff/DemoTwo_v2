package ru.sapteh.controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import org.controlsfx.control.GridView;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Product;
import ru.sapteh.service.ProductDaoImpl;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private final SessionFactory factory;

    public MainController(){
        factory = new Configuration().configure().buildSessionFactory();
    }

    //Контейнер для всей карты
    public GridView<MapTile> gridView;

    //класс-посредник, отображающий URL изображения в ImageView
    public ImagesAdapter gridViewAdapter;

    private final ObservableList<Product> products = FXCollections.observableArrayList();
    private final ObservableList<MapTile> mapTiles = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        gridViewAdapter = new ImagesAdapter(gridView);
        gridViewAdapter.setData(mapTiles);
    }


    private void initData(){
        Dao<Product, Integer> productDaoImpl = new ProductDaoImpl(factory);
        products.addAll(productDaoImpl.findByAll());

        for(Product product : products){
            mapTiles.add(
                    new MapTile(
                            "/" + product.getMainImagePath(),
                            product.getTitle(),
                            product.getIsActive(),
                            product.getCost())
                    );
        }
    }
}
