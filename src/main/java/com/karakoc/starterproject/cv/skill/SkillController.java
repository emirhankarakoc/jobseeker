package com.karakoc.starterproject.cv.skill;


import com.karakoc.starterproject.cv.skill.requests.CreateSkillRequest;
import com.karakoc.starterproject.cv.training.TrainingDTO;
import com.karakoc.starterproject.cv.training.TrainingService;
import com.karakoc.starterproject.cv.training.requests.CreateTrainingRequest;
import com.karakoc.starterproject.security.JWTService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/skills")
@RestController
@Tag(name = "Skill Controller")
public class SkillController {
    private final SkillService service;
    private final JWTService jwtService;


    @PostMapping
    public SkillDTO postSkill(@RequestBody CreateSkillRequest r){
        jwtService.validateToken(r.getToken());
        return service.createSkill(r);
    }
    @GetMapping("/{id}")
    public SkillDTO getSkill(@PathVariable String id){
        return service.getSkillById(id);
    }


}
