package com.lcwd.orm;

import com.lcwd.orm.entities.*;
import com.lcwd.orm.repositories.CategoryRepository;
import com.lcwd.orm.repositories.ProductRepository;
import com.lcwd.orm.repositories.StudentRepository;
import com.lcwd.orm.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class LearningSpringOrmApplication implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    private Logger logger= LoggerFactory.getLogger(LearningSpringOrmApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringOrmApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        //              add new user


//        User user = new User();
//        user.setName("pranav");
//        user.setCity("delhi");
//        user.setAge(34);
//        User savedUser = userService.saveUser(user);
//        System.out.println(savedUser);

        // get All user

//        List<User> allUser = userService.getAllUser();
//        logger.info("users size is {}",allUser.size());
//        logger.info("get all user {}",allUser);

        // get single user

//        User user = userService.getUser(20);
//        logger.info(" single user {}",user);

        // update user

//        User user = new User();
//        user.setName("Ankit Verma");
//        user.setCity("kanpur");
//        user.setAge(28);
//        User updatedUser = userService.updateUser(user, 1);
//        logger.info("updated user details {}",updatedUser);

        //deleteuser

//        userService.deleteUser(2);


        // One To One User

//        Student student = new Student();
//        student.setStudentId(10);
//        student.setStudentName("Pranav Verma");
//        student.setAbout("I am software engineer");
//
//        Laptop laptop = new Laptop();
//        laptop.setLaptopId(10);
//        laptop.setBrand("HCL");
//        laptop.setModelNumber("ABC123");
//
//
//        laptop.setStudent(student);
//        student.setLaptop(laptop);
//
//
//
//        Student save = studentRepository.save(student);
//        logger.info("saved student {}",save.getStudentName());


//        Student student = studentRepository.findById(10).get();
//        logger.info("Student is {}",student.getStudentName());
//
//        Laptop laptop = student.getLaptop();
//        logger.info("Laptop is {}", laptop.getBrand(),laptop.getModelNumber());


        // One To Many

//        Student student = new Student();
//        student.setStudentId(101);
//        student.setStudentName("Shalaj Verma");
//        student.setAbout("I am software engineer");
//
//        Address address = new Address();
//        address.setAddressId(151);
//        address.setCity("Agra");
//        address.setCountry("india");
//        address.setStreet("bagh Anta");
//        address.setStudent(student);
//
//        Address address1 = new Address();
//        address1.setAddressId(152);
//        address1.setCity("Agra");
//        address1.setCountry("india");
//        address1.setStreet("abc");
//        address1.setStudent(student);
//
//        List<Address> addressList = new ArrayList<>();
//        addressList.add(address);
//        addressList.add(address1);
//
//        student.setAddressList(addressList);
//
//        Student save = studentRepository.save(student);


        // Many To Many

//        Product product1 = new Product();
//        product1.setpId("pid1");
//        product1.setProductName("Iphone 14 max pro");
//
//        Product product2 = new Product();
//        product2.setpId("pid2");
//        product2.setProductName("Samsung S22 Ultra");
//
//        Product product3 = new Product();
//        product3.setpId("pid3");
//        product3.setProductName("Samsung TV1234");
//
//
//        Category category1 = new Category();
//        category1.setcId("cid1");
//        category1.setTitle("Electronics");
//
//        Category category2 = new Category();
//        category2.setcId("cid2");
//        category2.setTitle("Mobile Phone");
//
//        List<Product> category1Products = category1.getProductList();
//        category1Products.add(product1);
//        category1Products.add(product2);
//        category1Products.add(product3);
//
//        List<Product> category2Products = category2.getProductList();
//        category2Products.add(product1);
//        category2Products.add(product2);
//
//        categoryRepository.save(category1);
//        categoryRepository.save(category2);

//        Category cid1 = categoryRepository.findById("cid1").get();
//        System.out.println(cid1.getProductList().size());
//
//        Category cid2 = categoryRepository.findById("cid2").get();
//        System.out.println(cid2.getProductList().size());
//
//        Product pid1 = productRepository.findById("pid1").get();
//        System.out.println(pid1.getCategories().size());

        // test custom query methods

//        Optional<Product> byProductName = productRepository.findByProductName("Iphone 14 max pro");
//        System.out.println(byProductName.isPresent());
//        System.out.println(byProductName.get().getProductName());
//
//        System.out.println("+++++++++++++++++++++++++++++++++++++++");
//        List<Product> tra = productRepository.findByProductNameEndingWith("tra");
//        tra.forEach(product -> {
//            System.out.println(product.getProductName());
//        });
//
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
//
//        List<Product> sung = productRepository.findByProductNameContaining("sung");
//        sung.forEach(product -> {
//            System.out.println(product.getProductName());
//        });
//
//        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
//
//        List<Product> samsungS22Ultra = productRepository.findByProductNameIn(Arrays.asList("Iphone 14 max pro", "Samsung S22 Ultra"));
//        samsungS22Ultra.forEach(product -> {
//            System.out.println(product.getProductName());
//        });

        List<Product> allProducts = productRepository.getAllProducts();
        allProducts.forEach(product -> System.out.println(product.getProductName()));

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        List<Product> allActiveProducts = productRepository.getAllActiveProducts();
        allActiveProducts.forEach(product -> System.out.println(product.getProductName()));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");

    }
}
