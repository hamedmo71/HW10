package com.maktab74.service;

import com.maktab74.base.service.BaseService;
import com.maktab74.base.service.BaseServiceImpl;
import com.maktab74.entity.Customer;
import com.maktab74.repository.CustomerRepository;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CustomerService extends BaseServiceImpl<Customer, Long, CustomerRepository>
        implements BaseService<Customer, Long> {
    public CustomerService(CustomerRepository repository) {
        super(repository);
    }

    @Override
    public void save(Customer customer) {
        try {
            repository.save(customer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Customer findById(Long id) {
        Customer customer=null;
        try {
            customer=repository.findById(id);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());;
        }
        return customer;
    }
}
