package com.example.JobSearch_Portal.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Job")


public class Job {

   @Id
   private Long jobId;

 @NotBlank
 private String jobTitle;

 @Column(name = "description")
 private String jobDescription;

 @NotBlank
 @Column(name = "location")
 private String jobLocation;

 @Column(name = "salary")
 @Min(value = 20000, message = "Salary should be above 20,000")
 @Max(value = 200000, message = "Salary should be below 2,00,000")
 private Double jobSalary;

 @NotBlank
 @Email(message = "Email is Invalid!!")
 private String companyEmail;

 @NotBlank
 private String  companyName;

 @NotBlank
 private String employerName;


 @Column(name = "type")
 @Enumerated(EnumType.STRING)
 private Type jobType;


 @Column(name = "applyDate")
 private LocalDate jobAppliedDate;

}
