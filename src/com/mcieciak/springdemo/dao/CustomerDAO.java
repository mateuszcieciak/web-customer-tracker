package com.mcieciak.springdemo.dao;

import com.mcieciak.springdemo.entity.Customer;

import java.util.List;


public interface CustomerDAO {
    public List<Customer> getCustomers();
}
