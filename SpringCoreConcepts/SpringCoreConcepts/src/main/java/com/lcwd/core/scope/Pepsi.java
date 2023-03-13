package com.lcwd.core.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Pepsi {
    @Autowired
    private Soda soda;
    public Pepsi(){
        System.out.println("Creating Pepsi");
    }

    public Soda getSoda() {
        return soda;
    }

    public void setSoda(Soda soda) {
        this.soda = soda;
    }

    public void drink(){
        System.out.println("Pepsi is very cool");
    }
}
