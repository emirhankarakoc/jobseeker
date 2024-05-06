package com.karakoc.starterproject.cv.skill;

import com.karakoc.starterproject.cv.skill.requests.CreateSkillRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Skill {

    @Id
    private String id;
    private String cvId;
    private String title;
    private String level;


    public static Skill createSimpleSkill(CreateSkillRequest r) {
        Skill skill = new Skill();
        skill.setId(UUID.randomUUID().toString());
        skill.setCvId(r.getCvId());
        skill.setTitle(r.getTitle());
        skill.setLevel(r.getLevel());
        return skill;
    }

    public static SkillDTO skillToDto(Skill s) {
        SkillDTO dto = new SkillDTO();
        dto.setId(s.getId());
        dto.setCvId(s.getCvId());
        dto.setTitle(s.getTitle());
        dto.setLevel(s.getLevel());
        return dto;
    }
}
