package com.example.JobSearch_Portal.Repository;

import com.example.JobSearch_Portal.Model.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository<Job, Long>{


    List<Job> findByJobType(Type jobType);
    List<Job> findByJobSalaryGreaterThanEqualAndJobType(Double jobSalary, Type jobType);
    List<Job> findByCompanyNameAndJobType(String companyName, Type jobType);
    List<Job> findByJobLocationOrderByJobSalaryDesc(String jobLocation);


    @Query(value = "select * from Job where job_Id = :id", nativeQuery = true)
    Job getJobsById(Long id);


    @Query(value = "select * from Job where location = :location", nativeQuery = true)
    List<Job> getAllJobsByLocation(@Param("location") String location);

}

