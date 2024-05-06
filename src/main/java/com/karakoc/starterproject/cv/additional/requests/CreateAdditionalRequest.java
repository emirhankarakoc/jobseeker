package com.karakoc.starterproject.cv.additional.requests;

import lombok.Data;

@Data
public class CreateAdditionalRequest {
    private String cvId;
    private String field;
    private  String token;
}
