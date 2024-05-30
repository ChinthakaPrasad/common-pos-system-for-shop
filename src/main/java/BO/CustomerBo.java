package BO;

import dao.CustomerDao;
import dto.CustomerDto;
import entity.Customer;

import java.util.ArrayList;
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
        Customer c = new Customer(dto.getCustomerName(),
                dto.getPhoneNumber(),
                dto.getNic(),
                dto.getRemarks(),
                null);
        return customerDao.updateCustomer(c);
    }

    @Override
    public boolean delete(CustomerDto dto) {
        return customerDao.deleteCustomer(dto.getCustomerId());
    }

    @Override
    public List<CustomerDto> all() {
        List<Customer> list = customerDao.getAll();
        List<CustomerDto> dtoList = new ArrayList<>();
        for(Customer c: list){
            dtoList.add(new CustomerDto(c.getCustomerId(),
                    c.getCustomerName(),
                    c.getPhoneNumber(),
                    c.getNic(),
                    c.getRemarks()));
        }
        return dtoList;
    }
}
