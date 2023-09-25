package lk.ijse.hibernate.config;

import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Item;
import lk.ijse.hibernate.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {
    private static  SessionFactoryConfig factoryConfig;
    private static SessionFactory sessionFactory;

   private SessionFactoryConfig(){


       sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure().build())
               .addAnnotatedClass(Customer.class)
               .addAnnotatedClass(Item.class)
               .addAnnotatedClass(Order.class)
               .getMetadataBuilder().
               applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build().buildSessionFactory();

       sessionFactory = new Configuration()
               .configure()
               .addAnnotatedClass(Customer.class)
               .addAnnotatedClass(Item.class)
               .addAnnotatedClass(Order.class)
               .buildSessionFactory();
   }

    public static SessionFactoryConfig getInstance() {
        return (null == factoryConfig) ? factoryConfig = new SessionFactoryConfig() : factoryConfig;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
