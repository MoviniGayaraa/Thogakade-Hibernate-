package lk.ijse.hibernate.bo.custom.impl;

import lk.ijse.hibernate.bo.custom.OrderBo;
import lk.ijse.hibernate.dao.custom.ItemDAO;
import lk.ijse.hibernate.dao.custom.OrderDAO;
import lk.ijse.hibernate.dao.custom.impl.ItemDAOImpl;
import lk.ijse.hibernate.dao.custom.impl.OrderDAOImpl;
import lk.ijse.hibernate.dto.ItemDTO;
import lk.ijse.hibernate.dto.OrderDTO;
import lk.ijse.hibernate.entity.Item;
import lk.ijse.hibernate.entity.Order;

public class OrderBOImpl implements OrderBo {
    OrderDAO orderDAO = new OrderDAOImpl();

    public boolean saveOrder(OrderDTO dto) throws Exception {
        return orderDAO.save(new Order(
                dto.getOrder_id(),
                dto.getCustomer_id(),
                dto.getDate(),
                dto.getQty()
        ));
    }


    public boolean deleteItem(int id) throws Exception {
        return orderDAO.delete(id);
    }
}
