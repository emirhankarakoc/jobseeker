package com.karakoc.starterproject.cv.language.requests;

import lombok.Data;

@Data
public class CreateLanguageRequest {
    private String cvId;
    private String title;
    private String level;
    private String token;
}
