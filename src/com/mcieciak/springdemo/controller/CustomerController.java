package com.mcieciak.springdemo.controller;

import com.mcieciak.springdemo.dao.CustomerDAO;
import com.mcieciak.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject customerDAO
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model theModel) {

        // get customers from DAO
        List<Customer> theCustomers=customerDAO.getCustomers();

        // adding customer to Model
        theModel.addAttribute("customers", theCustomers);

        return "list-customer";

    }
}
