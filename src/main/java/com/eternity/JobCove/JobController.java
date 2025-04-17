package com.eternity.JobCove;

import com.eternity.JobCove.model.JobPost;
import com.eternity.JobCove.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping("load")
    public String getLoad()
    {
        return service.load();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId)
    {
        return service.getJob(postId);
    }

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs()
    {
        return service.getAllJobs();
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost)
    {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost)
    {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId)
    {
        service.deleteJob(postId);
        return"Deleted Successful";
    }
}
