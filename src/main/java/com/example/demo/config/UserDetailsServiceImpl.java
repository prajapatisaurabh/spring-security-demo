package com.example.demo.config;

import com.example.demo.entity.Customer;
import com.example.demo.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SAURABH
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private CustomerRepo repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Customer> customers = repo.findByEmail(username);
        if (customers.size() == 0){
            throw  new UsernameNotFoundException("User Not found" + username);
        }
        return new UserServiceImpl(customers.get(0));
    }
}
