package com.karakoc.starterproject.cv.scheme;

import com.karakoc.starterproject.cv.scheme.requests.AssignImageToCVRequest;
import com.karakoc.starterproject.cv.scheme.requests.CreateCVRequest;
import com.karakoc.starterproject.exceptions.general.ForbiddenException;
import com.karakoc.starterproject.exceptions.general.NotfoundException;
import com.karakoc.starterproject.user.User;
import com.karakoc.starterproject.user.UserManager;
import com.karakoc.starterproject.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.karakoc.starterproject.cv.scheme.CVSchema.createSimpleCV;
import static com.karakoc.starterproject.cv.scheme.CVSchema.cvToDto;

@Service
@AllArgsConstructor
public class CVManager implements CVService{
    private final CVRepository repository;
    private final UserManager userManager;
    private final UserRepository userRepository;

    @Override
    public CVDto createCV(CreateCVRequest r) {
        CVSchema cv = createSimpleCV(r);
        cv.setAdditionals(new ArrayList<>());
        cv.setTrainings(new ArrayList<>());
        cv.setJobs(new ArrayList<>());
        cv.setSkills(new ArrayList<>());
        cv.setLanguages(new ArrayList<>());
        repository.save(cv);
        return cvToDto(cv);

    }

    @Override
    public CVDto assignImageToCV(AssignImageToCVRequest r) {
        User user = userManager.getUser(r.getToken());
        CVSchema cv = getCV(r.getCvId());
        cvBuAdaminMiKontroluYap(cv,user);
        cv.setImageId(r.getImageId());
        repository.save(cv);
        user.getCvs().add(cv);
        userRepository.save(user);

        return cvToDto(cv);
    }



    @Override
    public CVDto getCVById(String id) {
        CVSchema cv = getCV(id);
        return cvToDto(cv);
    }

    public CVSchema getCV(String cvId){
        CVSchema cv = repository.findById(cvId).orElseThrow(()->new NotfoundException("CV not found."));
        return cv;
    }

    public void cvBuAdaminMiKontroluYap(CVSchema cv,User user){
        if (!cv.getUserId().equals(user.getId())){
            throw new ForbiddenException("Forbidden.");
        }
    }




}
