package ru.sapteh.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ru.sapteh.model.Product;

public class ProductItemController {

    @FXML
    private ImageView imageView;
    @FXML
    private Label idLbl;
    @FXML
    private Label titleLbl;
    @FXML
    private Label costLbl;
    @FXML
    private Label DescriptionLbl;
    @FXML
    private Label imagePathLbl;
    @FXML
    private Label isActiveLbl;
    @FXML
    private Label manufacLbl;

    public void setData(Product product){
        Image image = new Image("/" + product.getMainImagePath());
        imageView.setImage(image);
        idLbl.setText(String.format("%d", product.getId()));
        titleLbl.setText(product.getTitle());
        costLbl.setText(String.format("%.2f", product.getCost()));
        DescriptionLbl.setText(product.getDescription());
        imagePathLbl.setText(product.getMainImagePath());
        isActiveLbl.setText(String.valueOf(product.getIsActive()));
        manufacLbl.setText(String.valueOf(product.getManufacturer().getName()));
    }
}
