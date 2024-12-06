package com.kinjo.Job.Job.dto;

import com.kinjo.Job.Job.Job;
import com.kinjo.Job.Job.external.Company;

public class JobWithCompanyDTO {

    private Job job;
    private Company company;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
