package com.karakoc.starterproject.cv.training;


import com.karakoc.starterproject.cv.training.requests.CreateTrainingRequest;
import com.karakoc.starterproject.security.JWTService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainings")
@AllArgsConstructor
@Tag(name = "Training Controller")
public class TrainingController {

private final TrainingService service;
private final JWTService jwtService;



    @PostMapping
    public TrainingDTO postTraining(@RequestBody CreateTrainingRequest r){
        jwtService.validateToken(r.getToken());
        return service.createTraining(r);
    }

    @GetMapping("/{id}")
    public TrainingDTO getTraining(@PathVariable String id){
        return service.getTrainingById(id);
    }

}
