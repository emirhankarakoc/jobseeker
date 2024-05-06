package com.karakoc.starterproject.cv.additional;

import com.karakoc.starterproject.cv.additional.requests.CreateAdditionalRequest;
import com.karakoc.starterproject.cv.scheme.CVManager;
import com.karakoc.starterproject.cv.scheme.CVRepository;
import com.karakoc.starterproject.cv.scheme.CVSchema;
import com.karakoc.starterproject.cv.training.Training;
import com.karakoc.starterproject.exceptions.general.NotfoundException;
import com.karakoc.starterproject.user.User;
import com.karakoc.starterproject.user.UserManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.karakoc.starterproject.cv.additional.Additional.additionalToDto;
import static com.karakoc.starterproject.cv.additional.Additional.createSimpleAdditional;
import static com.karakoc.starterproject.cv.training.Training.createSimpleTraining;
import static com.karakoc.starterproject.cv.training.Training.trainingToDto;

@Service
@AllArgsConstructor
public class AdditionalManager implements AdditionalService{
    private final AdditionalRepository repository;
    private final CVManager cvManager;
    private final CVRepository cvRepository;
    private final UserManager userManager;
    @Override
    public AdditionalDTO createAdditional(CreateAdditionalRequest r) {
        User user = userManager.getUser(r.getToken());
        CVSchema cv = cvManager.getCV(r.getCvId());
        cvManager.cvBuAdaminMiKontroluYap(cv,user);

        Additional a = createSimpleAdditional(r);
        repository.save(a);
        cv.getAdditionals().add(a);
        cvRepository.save(cv);
        return additionalToDto(a);
    }

    @Override
    public AdditionalDTO getAdditionalById(String id) {
        Additional a = getAdditional(id);
        return additionalToDto(a);
    }



    private Additional getAdditional(String id){
        Additional a = repository.findById(id).orElseThrow(()->new NotfoundException("Additional information not found."));
        return a;
    }
}
