package com.eternity.JobCove.repo;


import com.eternity.JobCove.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

}
