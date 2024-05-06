package com.karakoc.starterproject.cv.language;


import com.karakoc.starterproject.cv.language.requests.CreateLanguageRequest;
import com.karakoc.starterproject.cv.scheme.CVManager;
import com.karakoc.starterproject.cv.scheme.CVRepository;
import com.karakoc.starterproject.cv.scheme.CVSchema;
import com.karakoc.starterproject.cv.skill.Skill;
import com.karakoc.starterproject.exceptions.general.NotfoundException;
import com.karakoc.starterproject.user.User;
import com.karakoc.starterproject.user.UserManager;
import lombok.AllArgsConstructor;
import org.apache.commons.codec.language.bm.Lang;
import org.springframework.stereotype.Service;

import static com.karakoc.starterproject.cv.language.Language.languageToDto;
import static com.karakoc.starterproject.cv.skill.Skill.skillToDto;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService{
    private final LanguageRepository repository;
    private final CVManager cvManager;
    private final CVRepository cvRepository;
    private final UserManager userManager;

    /**
     * @param r
     * @return
     */
    @Override
    public LanguageDTO createLanguage(CreateLanguageRequest r) {
        User user = userManager.getUser(r.getToken());
        CVSchema cv = cvManager.getCV(r.getCvId());
        cvManager.cvBuAdaminMiKontroluYap(cv,user);

        Language l = Language.createSimpleLanguage(r);
        repository.save(l);
        cv.getLanguages().add(l);
        cvRepository.save(cv);
        return languageToDto(l);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public LanguageDTO getLanguageById(String id) {
        Language s = getLanguage(id);
        return languageToDto(s);
    }




    private Language getLanguage(String id){
        Language l = repository.findById(id).orElseThrow(()->new NotfoundException("Language not found."));
        return l;
    }
}
