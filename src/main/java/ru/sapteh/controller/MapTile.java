package ru.sapteh.controller;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.GeneratedValue;

@Getter
@ToString
//класс для хранения информации об одном кусочке карты
public class MapTile {

    //Ссылка на изображение
    private String tileUrl;

    private String titleBook;

    private int isActive;

    private double cost;

    public MapTile(String url, String titleBook, int isActive, double cost){
        this.tileUrl = url;
        this.titleBook = titleBook;
        this.isActive = isActive;
        this.cost = cost;
    }





}
