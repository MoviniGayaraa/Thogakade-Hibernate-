package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.ItemDTO;

public interface ItemBo extends SuperBO {
    boolean saveItem(ItemDTO dto) throws Exception;
    boolean updateItem(ItemDTO dto) throws Exception;
    boolean deleteItem(int id) throws Exception;
}
