package com.karakoc.starterproject.cv.language;

import com.karakoc.starterproject.cv.language.requests.CreateLanguageRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Language {

    @Id
    private String id;
    private String cvId;
    private String title;
    private String level;



    public static Language createSimpleLanguage(CreateLanguageRequest r) {
        Language language = new Language();
        language.setId(UUID.randomUUID().toString());
        language.setCvId(r.getCvId());
        language.setTitle(r.getTitle());
        language.setLevel(r.getLevel());
        return language;
    }

    public static LanguageDTO languageToDto(Language l) {
        LanguageDTO dto = new LanguageDTO();
        dto.setId(l.getId());
        dto.setCvId(l.getCvId());
        dto.setTitle(l.getTitle());
        dto.setLevel(l.getLevel());
        return dto;
    }
}
