package com.karakoc.starterproject.cv.skill;

import com.karakoc.starterproject.cv.skill.requests.CreateSkillRequest;
import com.karakoc.starterproject.cv.training.TrainingDTO;

public interface SkillService {

    SkillDTO createSkill(CreateSkillRequest r);
    SkillDTO getSkillById(String id);
}
