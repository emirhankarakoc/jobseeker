package com.karakoc.starterproject.cv.job;

import com.karakoc.starterproject.cv.job.requests.CreateJobRequest;

public interface JobService {

    JobDTO createJob(CreateJobRequest r);

    JobDTO getJobById(String id);


}
