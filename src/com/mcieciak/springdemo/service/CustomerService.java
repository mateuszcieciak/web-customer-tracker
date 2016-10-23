package com.mcieciak.springdemo.service;


import com.mcieciak.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);
}
