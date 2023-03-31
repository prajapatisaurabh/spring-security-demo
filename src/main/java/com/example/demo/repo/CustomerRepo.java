package com.example.demo.repo;

import com.example.demo.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author SAURABH
 */
public interface CustomerRepo extends CrudRepository<Customer, Integer> {
    List<Customer> findByEmail(String email);
}
