package com.karakoc.starterproject.cv.skill.requests;


import lombok.Data;

@Data
public class CreateSkillRequest {
    private String cvId;
    private String title;
    private String level;
    private String token;
}
