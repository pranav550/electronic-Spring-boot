package org.example.beans;

import org.springframework.stereotype.Component;

@Component
public class OrderService {
    public void createOrder(){
        System.out.println("order is created");
    }
}