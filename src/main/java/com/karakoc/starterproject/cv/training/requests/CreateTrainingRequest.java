package com.karakoc.starterproject.cv.training.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateTrainingRequest {
    private String cvId;
    private String title;
    private String company;
    private String city;
    private LocalDate startDate;
    private LocalDate endDate;
    private String isContinue;
    //bismillah
    private String description;
    private String token;
}
