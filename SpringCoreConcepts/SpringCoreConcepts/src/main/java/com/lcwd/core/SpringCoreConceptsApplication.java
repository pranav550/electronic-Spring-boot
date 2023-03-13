package com.lcwd.core;

import com.lcwd.core.couple.Animal;
import com.lcwd.core.couple.Person;
import com.lcwd.core.couple.Samosa;
import com.lcwd.core.scope.Pepsi;
import com.lcwd.core.scope.Soda;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import test.Test;


@SpringBootApplication
@ComponentScan(basePackages = {"com.lcwd.core","test"})
public class SpringCoreConceptsApplication {

	public static void main(String[] args) {

		// about the bean
        //@Component
		//about the  dependency
         //@Autowired
		// where to seach bean
		//com.lwcd.core.couple
		// @ComponentScan()

//		Animal animal = new Cat();
//		Person p = new Person(animal);
//		p.playWithAnimal();


		ApplicationContext context = SpringApplication.run(SpringCoreConceptsApplication.class, args);
//		Person personBean = context.getBean(Person.class);
//		personBean.playWithAnimal();
//
//		Test testBean = context.getBean(Test.class);
//		testBean.testing();

//		Animal cat = context.getBean("cat", Animal.class);
//		Animal dog = context.getBean("dog", Animal.class);
//		cat.play();
//		dog.play();

		// bean scope
		//first request
//		Pepsi bean = context.getBean(Pepsi.class);
//		System.out.println(bean);
//		bean.drink();
//
//		//second request
//		Pepsi bean1 = context.getBean(Pepsi.class);
//		System.out.println(bean1);

		Pepsi pepsi = context.getBean(Pepsi.class);
		System.out.println(pepsi);
		Soda soda = pepsi.getSoda();
		System.out.println(soda);

		Pepsi pepsi1 = context.getBean(Pepsi.class);
		System.out.println(pepsi1);
		Soda soda1 = pepsi.getSoda();
		System.out.println(soda1);

		Pepsi pepsi2 = context.getBean(Pepsi.class);
		System.out.println(pepsi2);
		Soda soda2 = pepsi.getSoda();
		System.out.println(soda2);

	}

	// declaring the bean using @Bean
//	@Bean(name="samosa1")
//	//@Primary
//	public Samosa getSamosa1(){
//		return new Samosa("spicy");
//	}
//
//	@Bean(name="samosa2")
//	public Samosa getSamosa2(){
//		return new Samosa("katha");
//	}

}
