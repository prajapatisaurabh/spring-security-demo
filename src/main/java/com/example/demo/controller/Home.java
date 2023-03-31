package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SAURABH
 */
@RestController
public class Home {

    @GetMapping("/main")
    public String main(){
        return "main Page";
    }

    @GetMapping("/account")
    public String account(){
        return "account page";
    }
    @GetMapping("/update")
    public String update(){
        return "update page";
    }
    @GetMapping("/balance")
    public String balance(){
        return "balance is 10";
    }
}
