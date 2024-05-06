package com.karakoc.starterproject.cv.scheme;


import com.karakoc.starterproject.cv.additional.Additional;
import com.karakoc.starterproject.cv.job.Job;
import com.karakoc.starterproject.cv.language.Language;
import com.karakoc.starterproject.cv.scheme.requests.CreateCVRequest;
import com.karakoc.starterproject.cv.skill.Skill;
import com.karakoc.starterproject.cv.training.Training;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class CVSchema  {

    @Id
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


    @OneToMany
    @JoinColumn(name = "additionalId")
    private List<Additional> additionals;


    @OneToMany
    @JoinColumn(name = "trainingId")
    private List<Training> trainings;


    @OneToMany
    @JoinColumn(name = "jobId")
    private List<Job> jobs;


    @OneToMany
    @JoinColumn(name = "skillId")
    private List<Skill> skills;

    @OneToMany
    @JoinColumn(name = "languageId")
    private List<Language> languages;

    private String bottomInformation;


    public static CVSchema createSimpleCV(CreateCVRequest r) {
        CVSchema cv = new CVSchema();

        cv.setId(UUID.randomUUID().toString());
        cv.setUserId(r.getUserId());
        cv.setFirstname(r.getFirstname());
        cv.setLastname(r.getLastname());
        cv.setEmail(r.getEmail());
        cv.setTitle(r.getTitle());
        cv.setPhoneNumber(r.getPhoneNumber());
        cv.setAdress(r.getAdress());
        cv.setPostCode(r.getPostCode());
        cv.setCity(r.getCity());
        cv.setBirthDate(r.getBirthDate());
        cv.setBirthPlace(r.getBirthPlace());
        cv.setCarLicence(r.getCarLicence());
        cv.setGender(r.getGender());
        cv.setNationality(r.getNationality());
        cv.setMarriedStatus(r.getMarriedStatus());
        cv.setWebsite(r.getWebsite());
        cv.setLinkedin(r.getLinkedin());
        cv.setBottomInformation(r.getBottomInformation());

        return cv;
    }

    public static CVDto cvToDto(CVSchema cv) {
        CVDto cvDto = new CVDto();
        cvDto.setId(cv.getId());
        cvDto.setUserId(cv.getUserId());
        cvDto.setImageId(cv.getImageId());
        cvDto.setFirstname(cv.getFirstname());
        cvDto.setLastname(cv.getLastname());
        cvDto.setEmail(cv.getEmail());
        cvDto.setTitle(cv.getTitle());
        cvDto.setPhoneNumber(cv.getPhoneNumber());
        cvDto.setAdress(cv.getAdress());
        cvDto.setPostCode(cv.getPostCode());
        cvDto.setCity(cv.getCity());
        cvDto.setBirthDate(cv.getBirthDate());
        cvDto.setBirthPlace(cv.getBirthPlace());
        cvDto.setCarLicence(cv.getCarLicence());
        cvDto.setGender(cv.getGender());
        cvDto.setNationality(cv.getNationality());
        cvDto.setMarriedStatus(cv.getMarriedStatus());
        cvDto.setWebsite(cv.getWebsite());
        cvDto.setLinkedin(cv.getLinkedin());
        cvDto.setBottomInformation(cv.getBottomInformation());
        cvDto.setAdditionals(cv.getAdditionals());
        cvDto.setTrainings(cv.getTrainings());
        cvDto.setJobs(cv.getJobs());
        cvDto.setSkills(cv.getSkills());
        cvDto.setLanguages(cv.getLanguages());
        return cvDto;
    }


    public static List<CVDto> cvsToDtos(List<CVSchema> cvs){
        List<CVDto> dtoList = new ArrayList<>();
        for (CVSchema cv: cvs){
            dtoList.add(cvToDto(cv));
        }
        return dtoList;
    }
//bunu her entity icin yazacagiz.
    //malesef ki lazim.
}





