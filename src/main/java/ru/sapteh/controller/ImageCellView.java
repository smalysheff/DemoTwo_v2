package ru.sapteh.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageCellView {

    @FXML
    private AnchorPane imageViewCellPane;

    @FXML
    private ImageView loadImageView;

    @FXML
    private Label titleBookLbl;



}
