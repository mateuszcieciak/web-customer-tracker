package com.mcieciak.springdemo.controller;

import com.mcieciak.springdemo.entity.Customer;
import com.mcieciak.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        List<Customer> theCustomers = customerService.getCustomers();

        // adding customer to Model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create ModeAttribute to bind form data
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){

        // saving the customer by using service
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }


}
