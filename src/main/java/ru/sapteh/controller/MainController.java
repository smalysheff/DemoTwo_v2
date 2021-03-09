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
import javafx.scene.control.ScrollPane;
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



    @FXML
    public BorderPane borderPane;
    @FXML
    public ScrollPane scrollPane;
    @FXML
    public TilePane tilePane;

    //Список прямоугольниов для заполнения
    ObservableList<Rectangle> rectangles = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Получение размера сцены по ширине и присвоение значения tilePane
        scrollPane.widthProperty().addListener((obj, oldValue, newValue) -> {
            tilePane.setPrefWidth(newValue.doubleValue());
            System.out.println(newValue);
        });

        for (int i = 0; i < 50; i++) {
            rectangles.add(new Rectangle(200, 200, Color.color(.2, .4, .5)));
        }

        tilePane.getChildren().addAll(rectangles);

        rectangles.forEach(r -> {
            r.setOnMouseClicked(event -> {
                System.out.println(r.hashCode());
                r.setFill(Color.RED);
                System.out.println(r.getFill());
            });
        });

    }
    
}
