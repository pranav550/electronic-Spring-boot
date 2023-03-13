package com.lcwd.todo;

import com.lcwd.todo.dao.TodoDao;
import com.lcwd.todo.models.Todo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.slf4j.Logger;

import java.util.Date;
import java.util.List;


@SpringBootApplication
public class TodoManagerApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(TodoManagerApplication.class);

	@Autowired
	private TodoDao todoDao;
	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Application Started");
//		JdbcTemplate template = todoDao.getTemplate();
//		logger.info("Template Object:{}",template);
////		logger.info("Template Object:{}",template.getDataSource());


		//create

//		Todo todo = new Todo();
//		todo.setId(1230);
//		todo.setTitle("this is creating spring jdbc");
//		todo.setContent("Great");
//		todo.setStatus("Pending");
//		todo.setAddedDate(new Date());
//		todo.setToDoDate(new Date());
//
//		todoDao.saveTodo(todo);

		// getSingle

//	Todo todo = todoDao.getTodo(123);
//	logger.info("TODO : {} single record",todo);

		// get all record

//		List<Todo> allTodos = todoDao.getAllTodos();
//		logger.info("TODO : {} All record",allTodos);

		//update record

//			Todo todo = todoDao.getTodo(1230);
//	logger.info("TODO : {} single record",todo);
//
//	todo.setTitle("Learn Spring boot Course");
//	todo.setContent("Learn Spring boot");
//	todo.setStatus("DONE");
//	todo.setToDoDate(new Date());
//	todo.setAddedDate(new Date());
//	todoDao.updateTodo(1230,todo);

		// delete todo

	///	todoDao.deleteTodo(1230);
//todoDao.deleteMultipleTodo(new int[]{23,45});
	}
}
