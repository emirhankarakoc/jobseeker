package com.karakoc.starterproject.cv.language;


import com.karakoc.starterproject.cv.language.requests.CreateLanguageRequest;
import com.karakoc.starterproject.cv.skill.SkillDTO;
import com.karakoc.starterproject.cv.skill.requests.CreateSkillRequest;
import com.karakoc.starterproject.security.JWTService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/languages")
@AllArgsConstructor
@Tag(name = "Language Controller")
public class LanguageController {
    private final LanguageService service;
    private final JWTService jwtService;


    @PostMapping
    public LanguageDTO postLanguage(@RequestBody CreateLanguageRequest r){
        jwtService.validateToken(r.getToken());
        return service.createLanguage(r);
    }
    @GetMapping("/{id}")
    public LanguageDTO getLanguage(@PathVariable String id){
        return service.getLanguageById(id);
    }


}
