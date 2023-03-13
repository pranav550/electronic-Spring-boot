package com.lcwd.mvc.SpringMvcProject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FeedBackController {
    @GetMapping("/feedbacks")
    public List<String> getFeedbacks(){
    List<String> feedbacks = Arrays.asList(
            "Good Course",
            "Nice one",
            "valuable things"
    );
    return feedbacks;
    }
    @PostMapping("/create-feedback")
    public String createFeedback(){
        System.out.println("FeedBack Created");
        return "Created Feedback";
    }
}
