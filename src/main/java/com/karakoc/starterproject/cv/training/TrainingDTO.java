package com.karakoc.starterproject.cv.training;

import lombok.Data;

import java.time.LocalDate;
@Data
public class TrainingDTO {
    private String id;
    private String cvId;
    private String title;
    private String company;
    private String city;
    private LocalDate startDate;
    private LocalDate endDate;
    private String isContinue;
//bismillah
    private String description;
}
