package lk.ijse.hibernate.bo.custom.impl;


import lk.ijse.hibernate.bo.custom.ItemBo;
import lk.ijse.hibernate.dao.custom.ItemDAO;
import lk.ijse.hibernate.dao.custom.impl.ItemDAOImpl;
import lk.ijse.hibernate.dto.ItemDTO;
import lk.ijse.hibernate.entity.Item;

public class ItemBOImpl implements ItemBo {
    ItemDAO itemDAO = new ItemDAOImpl();

    public boolean saveItem(ItemDTO dto) throws Exception {
        return itemDAO.save(new Item(
                dto.getItem_id(),
                dto.getItem_name(),
                dto.getQtyOnHand(),
                dto.getUnitPrice()
        ));
    }

    public boolean updateItem(ItemDTO dto) throws Exception {
        return itemDAO.update(new Item(
                dto.getItem_id(),
                dto.getItem_name(),
                dto.getQtyOnHand(),
                dto.getUnitPrice()
        ));
    }

    public boolean deleteItem(int id) throws Exception {
        return itemDAO.delete(id);
    }


}
