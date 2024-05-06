package com.karakoc.starterproject.cv.training;


import com.karakoc.starterproject.cv.training.requests.CreateTrainingRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class Training {
    @Id
    private String id;
    private String cvId;
    private String title;
    private String company;
    private String city;
    private LocalDate startDate;
    private LocalDate endDate;
    private String isContinue;
//bismillah
    @Column(columnDefinition = "TEXT")//burasi olmazsa 257. karakterde gotunuze girer.
    private String description;



    public static Training createSimpleTraining(CreateTrainingRequest r){
        Training training = new Training();
        training.setId(UUID.randomUUID().toString());
        training.setCvId(r.getCvId());
        training.setTitle(r.getTitle());
        training.setCompany(r.getCompany());
        training.setCity(r.getCity());
        training.setStartDate(r.getStartDate());
        training.setEndDate(r.getEndDate());
        training.setIsContinue(r.getIsContinue());
        training.setDescription(r.getDescription());
        return training;
    }

    public static TrainingDTO trainingToDto(Training t){
        TrainingDTO dto = new TrainingDTO();
        dto.setId(t.getId());
        dto.setCvId(t.getCvId());
        dto.setTitle(t.getTitle());
        dto.setCompany(t.getCompany());
        dto.setCity(t.getCity());
        dto.setStartDate(t.getStartDate());
        dto.setEndDate(t.getEndDate());
        dto.setIsContinue(t.getIsContinue());
        dto.setDescription(t.getDescription());
        return dto;
    }
}
