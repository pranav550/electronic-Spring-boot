package com.lcwd.mvc.SpringMvcProject.controllers;

import com.lcwd.mvc.SpringMvcProject.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody List<Student> students){
        System.out.println("student List: "+students.size());
        System.out.println(students);

//       Object name = student.get("name");
//        Object empId = student.get("empId");
//        System.out.println("name: "+name);
//        System.out.println("empId: "+empId);
        //System.out.println(student.getName());

//        List<String> foods = Arrays.asList(
//                "pizza",
//                "burger",
//                "aaaaaaa"
//        );

//        Map<String,Object> data = new HashMap<>();
//        data.put("content",students);
//        data.put("error","No Error Found");
//        data.put("currentDate",new Date());
//        data.put("systemInformation",System.getProperties());

        // return data;
        Student student = students.get(0);
        student.setDept("test");
        //return student
        ResponseEntity<Student> response = new ResponseEntity<>(student, HttpStatus.CREATED);
        return  response;


    }
}
