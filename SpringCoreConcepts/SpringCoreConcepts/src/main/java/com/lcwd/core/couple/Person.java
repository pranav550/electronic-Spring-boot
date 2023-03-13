package com.lcwd.core.couple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Autowired
    Animal animal;
    @Autowired
    Student student;
    @Autowired
    @Qualifier("samosa2")
    Samosa samosa;

// constructor based injection
//    @Autowired
//    public Person(Animal animal, Student student){
//        System.out.println("calling contructor autowiring");
//        this.animal=animal;
//        this.student=student;
//    }

    // setter based injection
    public Animal getAnimal() {
        return animal;
    }
    //@Autowired
    public void setAnimal(Animal animal) {
        System.out.println("setting animal");
        this.animal = animal;
    }

    public Student getStudent() {
        return student;
    }
    //@Autowired
    public void setStudent(Student student) {
        System.out.println("setting student");
        this.student = student;
    }

    public void playWithAnimal(){
        animal.play();
        student.detail();
        samosa.eat();
    }
}
