package lk.ijse.hibernate.dao.custom;

import lk.ijse.hibernate.dao.SuperDAO;
import lk.ijse.hibernate.entity.Customer;


public interface CustomerDAO extends SuperDAO {
     boolean save(Customer customer) throws Exception;
     boolean update(Customer customer) throws Exception;
     boolean delete(int id) throws Exception;

}
