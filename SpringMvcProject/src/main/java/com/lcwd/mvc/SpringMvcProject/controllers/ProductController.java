package com.lcwd.mvc.SpringMvcProject.controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/getProduct")
    public  String getProduct(
            @RequestParam("productName") String name,
            @RequestParam(value="productRating",defaultValue = "0",required = false) int rating,
            @RequestParam("productId") int id
            ){
        System.out.println("productName:"+name);
        System.out.println("productRating:"+rating);
        System.out.println("productId:"+id);
        return "This is testing product";
    }

    @RequestMapping("/checkProduct/{productId}/{productName}/{productRating}")
    public String checkProduct(
            @PathVariable("productId") int id,
            @PathVariable String productName,
            @PathVariable int productRating
    ){
        System.out.println("Product Name:"+ productName);
        System.out.println("product Id:"+ id);
        System.out.println("product Rating:" +productRating);

        logger.error("ProductName {}", productName);
        logger.warn("ProductId {}",id);
        logger.info("productRating {}",productRating);
        logger.debug("this is testing for debug");
        return "this is checking the concept of path variable";
    }

}
