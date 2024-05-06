package com.karakoc.starterproject.cv.additional;


import com.karakoc.starterproject.cv.additional.requests.CreateAdditionalRequest;
import com.karakoc.starterproject.cv.training.TrainingDTO;
import com.karakoc.starterproject.cv.training.requests.CreateTrainingRequest;
import com.karakoc.starterproject.security.JWTService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/additionals")
@Tag(name = "Additinal Informations Controller")
@AllArgsConstructor
public class AdditionalController {
    private final AdditionalService service;
    private final JWTService jwtService;


    @PostMapping
    public AdditionalDTO postAdditional(@RequestBody CreateAdditionalRequest r){
        jwtService.validateToken(r.getToken());
        return service.createAdditional(r);
    }

    @GetMapping("/{id}")
    public AdditionalDTO getAdditional(@PathVariable String id){
        return service.getAdditionalById(id);
    }

}
