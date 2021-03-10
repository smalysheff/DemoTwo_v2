package ru.sapteh.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ru.sapteh.model.Product;

public class TileController {

    @FXML
    public ImageView loadedImage;

    @FXML
    public Label bookTitleLbl;

    @FXML
    public Label costLbl;

    @FXML
    public Label isActiveLbl;

    public void setData(Product product){
        Image image = new Image("/" + product.getMainImagePath());
        loadedImage.setImage(image);
        bookTitleLbl.setText(subTitle(product.getTitle()));
        costLbl.setText(String.format("%.2f руб.", product.getCost()));
        isActiveLbl.setText(productActive(product.getIsActive()));
    }

    private String subTitle(String title){
        if(title.length() < 15)
            return title;
        return title.substring(0, 15) + "...";
    }

    private String productActive(int isActive){
        return isActive == 0 ? "не активен" : "";
    }

}
