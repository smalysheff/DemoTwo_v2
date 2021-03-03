package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Manufacturer;

import java.util.List;

public class ManufacturerDaoImpl implements Dao<Manufacturer, Integer> {
    private final SessionFactory factory;

    public ManufacturerDaoImpl(SessionFactory factory){
        this.factory = factory;
    }


    @Override
    public List<Manufacturer> findByAll() {
        try(Session session = factory.openSession()){
            return session.createQuery("FROM Manufacturer", Manufacturer.class).list();
        }
    }

    @Override
    public Manufacturer findById(Integer id) {
        try(Session session = factory.openSession()){
            return session.get(Manufacturer.class, id);
        }
    }

    @Override
    public void add(Manufacturer manufacturer) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(manufacturer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Manufacturer manufacturer) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(manufacturer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Manufacturer manufacturer) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(manufacturer);
            session.getTransaction().commit();
        }
    }
}
