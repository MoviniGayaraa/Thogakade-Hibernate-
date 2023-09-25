package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.config.SessionFactoryConfig;
import lk.ijse.hibernate.dao.custom.CustomerDAO;
import lk.ijse.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerDAOImpl implements CustomerDAO {
    private final Session session = SessionFactoryConfig.getInstance().getSession();

    @Override
    public boolean save(Customer customer) throws Exception{
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction =session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
   public boolean update(Customer customer) throws Exception{
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction =session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
        return true;
   }

   @Override
   public boolean delete(int id) throws Exception{
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction =session.beginTransaction();
        Customer customer = session.load(Customer.class,id);
        session.delete(customer);
        session.close();
        return true;
   }
}
