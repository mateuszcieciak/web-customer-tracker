package com.mcieciak.springdemo.dao;

import com.mcieciak.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject SessionFactory
    @Autowired
    private SessionFactory sessionFactory;

    // delete @Transactional if we have service layer

    @Override
    public List<Customer> getCustomers() {

        // get the current session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);

        // execute the query and getting result
        List<Customer> customers = query.getResultList();

        // return result
        return customers;
    }
}
