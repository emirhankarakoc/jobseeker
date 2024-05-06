package com.karakoc.starterproject.cv.skill;


import com.karakoc.starterproject.cv.scheme.CVManager;
import com.karakoc.starterproject.cv.scheme.CVRepository;
import com.karakoc.starterproject.cv.scheme.CVSchema;
import com.karakoc.starterproject.cv.skill.requests.CreateSkillRequest;
import com.karakoc.starterproject.exceptions.general.NotfoundException;
import com.karakoc.starterproject.user.User;
import com.karakoc.starterproject.user.UserManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.karakoc.starterproject.cv.skill.Skill.skillToDto;

@Service
@AllArgsConstructor
public class SkillManager implements  SkillService {

    private final SkillRepository repository;
    private final CVManager cvManager;
    private final CVRepository cvRepository;
    private final UserManager userManager;

    @Override
    public SkillDTO createSkill(CreateSkillRequest r) {
        User user = userManager.getUser(r.getToken());
        CVSchema cv = cvManager.getCV(r.getCvId());
        cvManager.cvBuAdaminMiKontroluYap(cv,user);

        Skill skill = Skill.createSimpleSkill(r);
        repository.save(skill);
        cv.getSkills().add(skill);
        cvRepository.save(cv);
        return skillToDto(skill);

    }

    @Override
    public SkillDTO getSkillById(String id) {
        Skill s = getSkill(id);
        return skillToDto(s);
    }


    private Skill getSkill(String id){
        Skill s = repository.findById(id).orElseThrow(()->new NotfoundException("Skill not found."));
        return s;
    }
}
