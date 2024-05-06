package com.karakoc.starterproject.cv.scheme.requests;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;

@Data
public class AssignImageToCVRequest extends BaseCVRequest {
    private String imageId;

}
