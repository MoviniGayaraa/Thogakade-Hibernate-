package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.config.SessionFactoryConfig;
import lk.ijse.hibernate.dao.custom.OrderDAO;
import lk.ijse.hibernate.entity.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDAOImpl implements OrderDAO {
    private final Session session = SessionFactoryConfig.getInstance().getSession();

    @Override
    public boolean save(Order order) throws Exception{
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction =session.beginTransaction();
        session.save(order);
        transaction.commit();
        session.close();
        return true;
    }


    @Override
    public boolean delete(int id) throws Exception{
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction =session.beginTransaction();
        Order order = session.load(Order.class,id);
        session.delete(order);
        session.close();
        return true;
    }
}
