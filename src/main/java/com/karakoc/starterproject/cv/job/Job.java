package com.karakoc.starterproject.cv.job;


import com.karakoc.starterproject.cv.job.requests.CreateJobRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class Job {

    @Id
    private String id;

    private String cvId;

    private String title;
    private String company;
    private String city;
    private LocalDate startDate;
    private LocalDate endDate;
    private String isContinue;

    @Column(columnDefinition = "TEXT")
    private String description;


    public static JobDTO jobToDto(Job j) {
        JobDTO dto = new JobDTO();
        dto.setId(j.getId());
        dto.setCvId(j.getCvId());
        dto.setTitle(j.getTitle());
        dto.setCompany(j.getCompany());
        dto.setCity(j.getCity());
        dto.setStartDate(j.getStartDate());
        dto.setEndDate(j.getEndDate());
        dto.setIsContinue(j.getIsContinue());
        dto.setDescription(j.getDescription());
        return dto;
    }

    public static Job createSimpleJob(CreateJobRequest r) {
        Job job = new Job();
        job.setId(UUID.randomUUID().toString());
        job.setCvId(r.getCvId());
        job.setTitle(r.getTitle());
        job.setCompany(r.getCompany());
        job.setCity(r.getCity());
        job.setStartDate(r.getStartDate());
        job.setEndDate(r.getEndDate());
        job.setIsContinue(r.getIsContinue());
        job.setDescription(r.getDescription());
        return job;
    }


}
