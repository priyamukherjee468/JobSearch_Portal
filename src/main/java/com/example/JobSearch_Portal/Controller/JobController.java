package com.example.JobSearch_Portal.Controller;

import com.example.JobSearch_Portal.Model.Job;
import com.example.JobSearch_Portal.Service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@Validated
public class JobController {
    @Autowired
    JobService jobService;

    @GetMapping("jobs")
    public Iterable<Job> getAllJobs() {
        return jobService.getAllJobs();
    }


    @PostMapping("jobs/addJobs")
    public String addJobsList(@RequestBody @Valid List<Job> job) {
        return jobService.addJobsList(job);
    }


    @PostMapping("jobs/add")
    public String addJob(@Valid @RequestBody Job job) {
        return jobService.addJob(job);
    }


    @GetMapping("jobs/count")
    public String getCountJobs() {
        return jobService.getCountJobs();
    }


    @GetMapping("jobs/jobType/{type}")
    public List<Job> getAllJobsByJobType(@PathVariable Type type) {
        return jobService.getAllJobsByJobType(type);
    }

    @GetMapping("jobs/type/{type}/salary")
    public List<Job> getAllJobsByGreaterOrEqualSalaryAndJobType(@RequestParam Double jobSalary, @PathVariable Type type) {
        return jobService.getAllJobsByGreaterOrEqualSalaryAndJobType(jobSalary, type);
    }

    @GetMapping("jobs/companyName/{companyName}/type")
    public List<Job> getAllJobsByCompanyNameAndTypeEqual(@PathVariable String companyName, @RequestParam Type type) {
        return jobService.getAllJobsByCompanyNameAndTypeEqual(companyName, type);
    }


    @GetMapping("jobs/location/{location}")
    public List<Job> getAllJobsByLocationAndSortedSalaryDesc(@PathVariable String location) {
        return jobService.getAllJobsByLocationAndSortedSalaryDesc(location);
    }


    @GetMapping("jobs/jobId/{id}")
    public Job getJobsById(@PathVariable Long id) {
        return jobService.getJobsById(id);
    }

    @GetMapping("jobs/location/{location}/jobList")
    public List<Job> getAllJobsByLocation(@PathVariable String location) {
        return jobService.getAllJobsByLocation(location);
    }
    @DeleteMapping("job/{id}")
    public String deleteJobById(@PathVariable Integer id){
        return jobService.deleteJobById(id);
    }

}
