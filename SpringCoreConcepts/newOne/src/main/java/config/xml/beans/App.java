package config.xml.beans;

import another.world.Repo;
import org.example.beans.CartService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("Xml main Started");

        ApplicationContext context = new ClassPathXmlApplicationContext("config/xml/beans/config.xml");
        Student student1 = context.getBean("student1", Student.class);
        student1.sayHello();
        System.out.println(student1);
        Address address = student1.getAddress();
        System.out.println(address);
        String city = address.getCity();
        System.out.println(city);

        Repo bean = context.getBean(Repo.class);
        bean.getUser();

        CartService bean1 = context.getBean(CartService.class);
        bean1.createCart();
    }
}
