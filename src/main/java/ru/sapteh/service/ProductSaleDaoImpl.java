package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.ProductSale;

import java.util.List;

public class ProductSaleDaoImpl implements Dao<ProductSale, Integer> {
    private final SessionFactory factory;

    public ProductSaleDaoImpl(SessionFactory factory){
        this.factory = factory;
    }


    @Override
    public List<ProductSale> findByAll() {
        try(Session session = factory.openSession()){
            return session.createQuery("FROM ProducSale", ProductSale.class).list();
        }
    }

    @Override
    public ProductSale findById(Integer id) {
        try(Session session = factory.openSession()){
            return session.get(ProductSale.class, id);
        }
    }

    @Override
    public void add(ProductSale productSale) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(productSale);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(ProductSale productSale) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(productSale);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(ProductSale productSale) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(productSale);
            session.getTransaction().commit();
        }
    }
}

