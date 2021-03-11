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
import javafx.stage.Stage;
import lombok.SneakyThrows;
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

    private final ObservableList<Product> products = FXCollections.observableArrayList();

    private MyListener myListener;

    FlowPane flowPane;

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rubberWindow();
        initData();

        // Открытие нового окна
        if(!products.isEmpty()){
            Stage stage = new Stage();
            stage.setTitle("Product info");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/productItem.fxml"));
            AnchorPane anchorPane = loader.load();

            stage.setScene(new Scene(anchorPane));
            stage.show();

            ProductItemController productController = loader.getController();

            myListener = new MyListener() {
                @Override
                public void onClickListener(Product product) {
                    productController.setData(product);
                }
            };
        }


        for(Product product : products){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/tile.fxml"));
            flowPane = loader.load();

            TileController tileController = loader.getController();
            tileController.setData(product, myListener);

            tilePane.getChildren().add(flowPane);

            //цвет фона плитки, если не активен
            if(product.getIsActive() == 0){
                flowPane.setStyle("-fx-background-color: #b4b3b3");
            }
        }

    }

    private void rubberWindow() {
        scrollPane.widthProperty().addListener((obj, oldValue, newValue) -> {
            tilePane.setPrefWidth(newValue.doubleValue());
        });
    }

    private void initData(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Dao<Product, Integer> productDaoImpl = new ProductDaoImpl(factory);
        products.addAll(productDaoImpl.findByAll());
    }
    
}
