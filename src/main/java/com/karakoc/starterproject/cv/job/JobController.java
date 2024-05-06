package com.karakoc.starterproject.cv.job;


import com.karakoc.starterproject.cv.job.requests.CreateJobRequest;
import com.karakoc.starterproject.security.JWTService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
@Tag(name="Job Controller")
public class JobController {
    private final JWTService jwtService;
    private final JobService service;


    @PostMapping
    public JobDTO postJob(@RequestBody CreateJobRequest r){
        jwtService.validateToken(r.getToken());
        return service.createJob(r);
    }

    @GetMapping("/{id}")
    public JobDTO getJob(@PathVariable String id){
        return service.getJobById(id);
    }
}
