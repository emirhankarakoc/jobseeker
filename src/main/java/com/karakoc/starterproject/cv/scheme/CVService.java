package com.karakoc.starterproject.cv.scheme;

import com.karakoc.starterproject.cv.scheme.requests.AssignImageToCVRequest;
import com.karakoc.starterproject.cv.scheme.requests.CreateCVRequest;

public interface CVService {


    CVDto createCV(CreateCVRequest r);
    CVDto getCVById(String id);
    CVDto assignImageToCV(AssignImageToCVRequest r);

}
