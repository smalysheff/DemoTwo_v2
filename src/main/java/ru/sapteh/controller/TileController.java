package ru.sapteh.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import ru.sapteh.model.Product;

public class TileController {

    @FXML
    private ImageView loadedImage;

    @FXML
    private Label bookTitleLbl;

    @FXML
    private Label costLbl;

    @FXML
    private Label isActiveLbl;

    @FXML
    private void click(MouseEvent event){
        myListener.onClickListener(product);
    }

    private MyListener myListener;

    private Product product;



    public void setData(Product product, MyListener myListener){
        this.product = product;
        this.myListener = myListener;
        Image image = new Image("/" + product.getMainImagePath());
        loadedImage.setImage(image);
        bookTitleLbl.setText(subTitle(product.getTitle()));
        costLbl.setText(String.format("%.2f руб.", product.getCost()));
        isActiveLbl.setText(productActive(product.getIsActive()));
    }

    //обрезаем название книги до 15 символов
    private String subTitle(String title){
        if(title.length() < 15)
            return title;
        return title.substring(0, 15) + "...";
    }

    private String productActive(int isActive){
        return isActive == 0 ? "не активен" : "";
    }

}
