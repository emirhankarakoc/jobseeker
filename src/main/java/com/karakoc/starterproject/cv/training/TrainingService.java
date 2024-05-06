package com.karakoc.starterproject.cv.training;

import com.karakoc.starterproject.cv.training.requests.CreateTrainingRequest;

public interface TrainingService {

    TrainingDTO createTraining(CreateTrainingRequest r);

    TrainingDTO getTrainingById(String id);



}
