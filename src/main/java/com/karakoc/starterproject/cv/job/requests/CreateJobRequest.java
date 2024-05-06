package com.karakoc.starterproject.cv.job.requests;


import lombok.Data;

import java.time.LocalDate;
@Data
public class CreateJobRequest {


    private String cvId;
    private String title;
    private String company;
    private String city;
    private LocalDate startDate;
    private LocalDate endDate;
    private String isContinue;
    private String description;
    private String token;
}
