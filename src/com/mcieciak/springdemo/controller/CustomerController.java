package com.mcieciak.springdemo.controller;

import com.mcieciak.springdemo.entity.Customer;
import com.mcieciak.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

//    // need to inject customerDAO
//    @Autowired
//    private CustomerDAO customerDAO;

    // need to inject customerService
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        // get customers from DAO
        List<Customer> theCustomers=customerService.getCustomers();

        // adding customer to Model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";

    }
}
