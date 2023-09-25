package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.CustomerDTO;

public interface CustomerBo extends SuperBO {
     boolean saveCustomer(CustomerDTO dto) throws Exception;
     boolean updateCustomer(CustomerDTO dto) throws Exception;
      boolean deleteCustomer(int id) throws Exception;
}
