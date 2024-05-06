package com.karakoc.starterproject.cv.job;


import lombok.Data;

import java.time.LocalDate;

@Data
public class JobDTO {
    private String id;

    private String cvId;

    private String title;
    private String company;
    private String city;
    private LocalDate startDate;
    private LocalDate endDate;
    private String isContinue;

    private String description;
}
