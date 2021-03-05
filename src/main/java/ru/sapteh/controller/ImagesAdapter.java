package ru.sapteh.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.FlowPane;
import org.controlsfx.control.GridCell;
import org.controlsfx.control.GridView;

import java.io.IOException;

//Класс служит для передачи объектов MapTile в GridView (через GridCell)
public class ImagesAdapter {

    private final GridView<MapTile> mapView;

    public ImagesAdapter(GridView<MapTile> mapView){
        this.mapView = mapView;
        //Фабрика, создающая новые ImageCell при необходимости
        mapView.setCellFactory(param -> new ImageCell());
    }

    public void setData(ObservableList<MapTile> mapTiles){
        mapView.setItems(mapTiles);
    }

    //одна ячейка GridView
    class ImageCell extends GridCell<MapTile>{

        //ImageView, отображающийся в ячейке
        private ImageCellView viewController;

        public ImageCell(){
            //Создаем ImageView для ячейки
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/imageCellView.fxml"));
            try {
                FlowPane root = loader.load();
                viewController = loader.getController();
                viewController.root = root;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void updateItem(MapTile item, boolean empty){

            //Здесь необходимо либо очистить ячейку, либо отобразить в ней новые данные
//
            if (empty || item == null) {
                //чистим
                setGraphic(null);
                viewController.clear();
            } else {
                //кладем новое изображение
//                if(item.getIsActive() == 0){
//                    viewController.root.setStyle("-fx-background-color: #c9c5c5");
//                }
                viewController.update(item.getTileUrl(), item.getTitleBook(), item.getIsActive(), item.getCost());
                setGraphic(viewController.root);
            }
        }
    }
}
