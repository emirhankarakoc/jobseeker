package com.karakoc.starterproject.cv.job;

import com.karakoc.starterproject.cv.job.requests.CreateJobRequest;
import com.karakoc.starterproject.cv.scheme.CVManager;
import com.karakoc.starterproject.cv.scheme.CVRepository;
import com.karakoc.starterproject.cv.scheme.CVSchema;
import com.karakoc.starterproject.cv.scheme.CVService;
import com.karakoc.starterproject.exceptions.general.NotfoundException;
import com.karakoc.starterproject.user.User;
import com.karakoc.starterproject.user.UserManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.karakoc.starterproject.cv.job.Job.createSimpleJob;
import static com.karakoc.starterproject.cv.job.Job.jobToDto;

@Service
@AllArgsConstructor
public class JobManager implements JobService{
    private final JobRepository repository;
    private final UserManager userManager;
    private final CVManager cvManager;
    private final CVRepository cvRepository;



    @Override
    public JobDTO createJob(CreateJobRequest r) {
        Job job = createSimpleJob(r);
        User user = userManager.getUser(r.getToken());
        CVSchema cv = cvManager.getCV(r.getCvId());
        cvManager.cvBuAdaminMiKontroluYap(cv,user);
        cv.getJobs().add(job);
        repository.save(job);
        cvRepository.save(cv);
        return jobToDto(job);
    }

    @Override
    public JobDTO getJobById(String id) {
        Job job = getJobStatic(id);
        return jobToDto(job);
    }



    private Job getJobStatic(String id){
        Job job = repository.findById(id).orElseThrow(()->new NotfoundException("Job not found."));
        return job;
    }
}
