package com.kinjo.Job.Job;

import com.kinjo.Job.Job.dto.JobWithCompanyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")   //     to map everything whenever /jobs is called
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobWithCompanyDTO>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity <String>createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>( "Job added successfully",HttpStatus.OK);
    }


    // to delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = jobService.deletJobById(id);
        if(deleted){
            return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // to get job by id
    @GetMapping("/{id}")
    public ResponseEntity<Job>getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job != null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //      For updating job
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Job updateJob){
        boolean updated = jobService.updateJob(id, updateJob);
        if(updated){
            return new ResponseEntity<>("Update successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Can't update", HttpStatus.NOT_FOUND);
        }
    }
}
