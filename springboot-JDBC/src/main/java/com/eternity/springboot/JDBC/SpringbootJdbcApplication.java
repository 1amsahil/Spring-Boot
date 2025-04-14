package com.eternity.springboot.JDBC;

import com.eternity.springboot.JDBC.model.Student;
import com.eternity.springboot.JDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringbootJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootJdbcApplication.class, args);

		Student st =  context.getBean(Student.class);

		st.setRollNo(161);
		st.setName("Sahil");
		st.setMarks(74);

		StudentService service = context.getBean(StudentService.class);
//		service.addStudent(st);

		List<Student> students = service.getStudents();
		System.out.println(students);
	}

}
