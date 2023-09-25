package lk.ijse.hibernate.dao.custom;

import lk.ijse.hibernate.dao.SuperDAO;
import lk.ijse.hibernate.entity.Order;

public interface OrderDAO extends SuperDAO {
     boolean save(Order order) throws Exception;
     boolean delete(int id) throws Exception;
}
