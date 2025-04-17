package com.eternity.springDataJPA;

import com.eternity.springDataJPA.model.Student;
import com.eternity.springDataJPA.repository.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

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
		s2.setName("Eternity");
		s2.setMarks(70);

		s3.setRollNo(163);
		s3.setName("Sahil2");
		s3.setMarks(80);

//// 	INSERT Query
//		save()
//		repo.save(s1);
//		repo.save(s2);
//		repo.save(s3);

////	READ Query
//		findAll()
//		System.out.println(repo.findAll());

//		findById
//		Optional<Student> s = repo.findById(161);
//		System.out.println(s.orElse( new Student() ));

//		findByName (Self-Created)
//		System.out.println(repo.findByName("Sahil"));
//		System.out.println(repo.findByMarksGreaterThan(70)); // JPA Auto Create this Method

////	Update Query
//		repo.save(s2);

////	Delete
		repo.delete(s3);

	}

}
