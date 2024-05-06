package com.karakoc.starterproject.cv.training;


import com.karakoc.starterproject.cv.scheme.CVManager;
import com.karakoc.starterproject.cv.scheme.CVRepository;
import com.karakoc.starterproject.cv.scheme.CVSchema;
import com.karakoc.starterproject.cv.training.requests.CreateTrainingRequest;
import com.karakoc.starterproject.exceptions.general.NotfoundException;
import com.karakoc.starterproject.user.User;
import com.karakoc.starterproject.user.UserManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.karakoc.starterproject.cv.training.Training.createSimpleTraining;
import static com.karakoc.starterproject.cv.training.Training.trainingToDto;

@Service
@AllArgsConstructor
public class TrainingManager implements TrainingService{
    private final TrainingRepository repository;
    private final CVManager cvManager;
    private final CVRepository cvRepository;
    private final UserManager userManager;

    @Transactional
    public TrainingDTO createTraining(CreateTrainingRequest r) {
        User user = userManager.getUser(r.getToken());
        CVSchema cv = cvManager.getCV(r.getCvId());
        cvManager.cvBuAdaminMiKontroluYap(cv,user);

        Training training = createSimpleTraining(r);
        repository.save(training);
        cv.getTrainings().add(training);
        cvRepository.save(cv);
        return trainingToDto(training);

    }

    @Override
    public TrainingDTO getTrainingById(String id) {
        Training t = getTraining(id);
        return trainingToDto(t);
    }





    private Training getTraining(String id){
        Training t = repository.findById(id).orElseThrow(()->new NotfoundException("Training not found."));
    return t;
    }
}
