package com.karakoc.starterproject.cv.language;

import com.karakoc.starterproject.cv.language.requests.CreateLanguageRequest;

public interface LanguageService {

    LanguageDTO createLanguage(CreateLanguageRequest r);
    LanguageDTO getLanguageById(String id);
}
