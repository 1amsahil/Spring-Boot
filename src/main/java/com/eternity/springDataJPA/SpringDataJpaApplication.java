package com.eternity.springDataJPA;

import com.eternity.springDataJPA.model.Student;
import com.eternity.springDataJPA.repository.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);

		StudentRepo repo = context.getBean(StudentRepo.class);

		Student s1 =  context.getBean(Student.class);
		Student s2 =  context.getBean(Student.class);
		Student s3 =  context.getBean(Student.class);

		s1.setRollNo(161);
		s1.setName("Sahil");
		s1.setMarks(74);

		s2.setRollNo(162);
		s2.setName("Sahil1");
		s2.setMarks(60);

		s3.setRollNo(163);
		s3.setName("Sahil2");
		s3.setMarks(80);


		repo.save(s1);
		repo.save(s2);
		repo.save(s3);
	}

}
