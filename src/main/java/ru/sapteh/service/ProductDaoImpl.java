package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Product;

import java.util.List;

public class ProductDaoImpl implements Dao<Product, Integer> {

    private final SessionFactory factory;

    public ProductDaoImpl(SessionFactory factory){
        this.factory = factory;
    }


    @Override
    public List<Product> findByAll() {
        try(Session session = factory.openSession()){
            return session.createQuery("FROM Product", Product.class).list();
        }
    }

    @Override
    public Product findById(Integer id) {
        try(Session session = factory.openSession()){
            return session.get(Product.class, id);
        }
    }

    @Override
    public void add(Product product) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Product product) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Product product) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        }
    }
}
