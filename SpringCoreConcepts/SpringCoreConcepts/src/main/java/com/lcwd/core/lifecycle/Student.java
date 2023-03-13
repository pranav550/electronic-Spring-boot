package com.lcwd.core.lifecycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("student5")
public class Student {

    public Student(){
        System.out.println("Creating Student");
    }

    @PostConstruct
    public void created(){
        // some initialization
        System.out.println("student bean is created: created()");
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println("# bye bye student bean: destroy()");
    }



}
