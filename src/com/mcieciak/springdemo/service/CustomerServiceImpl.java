package com.mcieciak.springdemo.service;


import com.mcieciak.springdemo.dao.CustomerDAO;
import com.mcieciak.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    // need to inject CustomerDao
    @Autowired
    private CustomerDAO customerDAO;

    // @Transactional Spring automatically start and ends transactions, deleting it from DAO!!!
    @Transactional
    @Override
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Transactional
    @Override
    public void saveCustomer(Customer theCustomer) {
        customerDAO.saveCustomer(theCustomer);
    }
}
