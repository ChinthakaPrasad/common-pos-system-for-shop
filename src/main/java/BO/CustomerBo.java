package BO;

import dao.CustomerDao;
import dto.CustomerDto;
import entity.Customer;

import java.util.List;

public class CustomerBo implements SuperBo<CustomerDto>{

    CustomerDao customerDao = new CustomerDao();

    @Override
    public boolean save(CustomerDto dto) {
        Customer c = new Customer(dto.getCustomerName(),
                dto.getPhoneNumber(),
                dto.getNic(),
                dto.getRemarks(),
                null);

        return customerDao.saveCustomer(c);
    }

    @Override
    public boolean update(CustomerDto dto) {
        return false;
    }

    @Override
    public boolean delete(CustomerDto dto) {
        return false;
    }

    @Override
    public List<CustomerDto> all() {
        return null;
    }
}
