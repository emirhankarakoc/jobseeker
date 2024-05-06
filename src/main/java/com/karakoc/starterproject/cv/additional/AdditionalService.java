package com.karakoc.starterproject.cv.additional;

import com.karakoc.starterproject.cv.additional.requests.CreateAdditionalRequest;

public interface AdditionalService {




    AdditionalDTO createAdditional(CreateAdditionalRequest r);
    AdditionalDTO getAdditionalById(String id);
}
