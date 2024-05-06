package com.karakoc.starterproject.cv.scheme;

import com.karakoc.starterproject.cv.additional.Additional;
import com.karakoc.starterproject.cv.job.Job;
import com.karakoc.starterproject.cv.language.Language;
import com.karakoc.starterproject.cv.skill.Skill;
import com.karakoc.starterproject.cv.training.Training;
import lombok.Data;

import java.util.List;
@Data
public class CVDto {

    private String id;

    private String userId;
    private String imageId;
    private String firstname;
    private String lastname;
    private String email;
    private String title;
    private String phoneNumber;
    private String adress;
    private String postCode;
    private String city;
    private String birthDate;
    private String birthPlace;
    private String carLicence;
    private String gender;
    private String nationality;
    private String marriedStatus;
    private String website;
    private String linkedin;
    private String bottomInformation;


    private List<Additional> additionals;



    private List<Training> trainings;



    private List<Job> jobs;



    private List<Skill> skills;


    private List<Language> languages;
}
