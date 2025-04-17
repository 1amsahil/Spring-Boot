package com.eternity.springDataJPA.repository;

import com.eternity.springDataJPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    @Query("select st from Student st where st.name = ?1 ")
    List<Student> findByName(String name);

    List<Student> findByMarksGreaterThan(int marks);
}
