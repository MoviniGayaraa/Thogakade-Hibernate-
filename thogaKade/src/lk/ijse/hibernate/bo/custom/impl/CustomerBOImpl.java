package lk.ijse.hibernate.bo.custom.impl;

import lk.ijse.hibernate.bo.custom.CustomerBo;
import lk.ijse.hibernate.dao.custom.CustomerDAO;
import lk.ijse.hibernate.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.hibernate.dto.CustomerDTO;
import lk.ijse.hibernate.entity.Customer;

public class CustomerBOImpl implements CustomerBo {
    CustomerDAO customerDAO= new CustomerDAOImpl();

    public boolean saveCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.save(new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getContact()
        ));
    }

    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.update(new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getContact()
        ));
    }

    public boolean deleteCustomer(int id) throws Exception {
        return customerDAO.delete(id);
    }

}
