package ru.sapteh;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;
import ru.sapteh.controller.MapTile;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Manufacturer;
import ru.sapteh.model.Product;
import ru.sapteh.model.ProductSale;
import ru.sapteh.service.ManufacturerDaoImpl;
import ru.sapteh.service.ProductDaoImpl;
import ru.sapteh.service.ProductSaleDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class ProgramConsole {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Dao<Product, Integer> productDaoImpl = new ProductDaoImpl(factory);
        Dao<ProductSale, Integer> productSaleDaoImpl = new ProductSaleDaoImpl(factory);
        Dao<Manufacturer, Integer> manufacturerDaoImpl = new ManufacturerDaoImpl(factory);

        List<Manufacturer> manufacturers = manufacturerDaoImpl.findByAll();
        List<Product> products = productDaoImpl.findByAll();
        List<ProductSale> productSales = productSaleDaoImpl.findByAll();

        manufacturers.forEach(System.out::println);
        System.out.println("============================================");
        products.forEach(System.out::println);
        System.out.println("=============================================");
        productSales.forEach(System.out::println);

    }
}
