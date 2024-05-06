package com.karakoc.starterproject.cv.scheme;


import com.karakoc.starterproject.cv.scheme.requests.CreateCVRequest;
import com.karakoc.starterproject.security.JWTService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cvs")
@AllArgsConstructor
@Tag(name = "CV Controller")
public class CVController {
    private  final CVService service;
    private final JWTService jwtService;


    @PostMapping
    public CVDto postCV(@RequestBody  CreateCVRequest r){
        jwtService.validateToken(r.getToken());
        return service.createCV(r);
    }

    @GetMapping("/{id}")
    public CVDto getCV(@PathVariable String id){
        return service.getCVById(id);
    }

    @GetMapping("/download/{id}")
    public void downloadCV(@PathVariable String cvId){
        //indir.
    }
}
