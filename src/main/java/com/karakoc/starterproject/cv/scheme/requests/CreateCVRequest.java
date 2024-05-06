package com.karakoc.starterproject.cv.scheme.requests;


import lombok.Data;

@Data
public class CreateCVRequest {
    private String userId;
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
    private String token;

}
