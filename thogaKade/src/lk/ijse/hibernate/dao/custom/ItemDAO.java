package lk.ijse.hibernate.dao.custom;

import lk.ijse.hibernate.dao.SuperDAO;
import lk.ijse.hibernate.entity.Item;

public interface ItemDAO extends SuperDAO {
     boolean save(Item item) throws Exception;
     boolean update(Item item) throws Exception;
     boolean delete(int id) throws Exception;
}
