package org.example;

import another.world.Repo;
import org.example.Config.AppConfig;
import org.example.beans.CartService;
import org.example.beans.OrderService;
import org.example.beans.UserService;
import org.example.web.AuthController;
import org.example.web.HomeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        // create a object of annotation based configration
       ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context);
        CartService cartService1 = context.getBean("cartService1", CartService.class);
        cartService1.createCart();

        // create a object of xmlbasedConfigration
//          ApplicationContext context = new ClassPathXmlApplicationContext();

        UserService bean = context.getBean(UserService.class);
        bean.saveUser();

        OrderService bean1 = context.getBean(OrderService.class);
        bean1.createOrder();

        HomeController bean2 = context.getBean(HomeController.class);
        bean2.homePage();

        AuthController bean3 = context.getBean(AuthController.class);
        bean3.login();

        Repo bean4 = context.getBean(Repo.class);
        bean4.getUser();
    }
}
