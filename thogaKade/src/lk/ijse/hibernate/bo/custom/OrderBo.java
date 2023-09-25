package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.OrderDTO;

public interface OrderBo extends SuperBO {
     boolean saveOrder(OrderDTO dto) throws Exception;
     boolean deleteItem(int id) throws Exception;
}
