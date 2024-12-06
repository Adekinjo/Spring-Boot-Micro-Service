package com.kinjo.Job.Job;

import com.kinjo.Job.Job.dto.JobWithCompanyDTO;

import java.util.List;

public interface JobService {

    List<JobWithCompanyDTO> findAll();

    //to create job
    void createJob(Job job);

    Job getJobById(Long id);

    // to delete
     boolean deletJobById(Long id);

     //update
    boolean updateJob(Long id, Job updateJob);
}
