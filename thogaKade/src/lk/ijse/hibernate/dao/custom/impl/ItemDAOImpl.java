package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.config.SessionFactoryConfig;
import lk.ijse.hibernate.dao.custom.ItemDAO;
import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ItemDAOImpl implements ItemDAO {
    private final Session session = SessionFactoryConfig.getInstance().getSession();

    public boolean save(Item item) throws Exception{
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction =session.beginTransaction();
        session.save(item);
        transaction.commit();
        session.close();
        return true;
    }

    public boolean update(Item item) throws Exception{
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction =session.beginTransaction();
        session.update(item);
        transaction.commit();
        session.close();
        return true;
    }

    public boolean delete(int id) throws Exception{
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction =session.beginTransaction();
        Item item = session.load(Item.class,id);
        session.delete(item);
        session.close();
        return true;
    }
}
