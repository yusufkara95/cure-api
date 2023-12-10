package de.yusufkara.cureapi.controller;

import de.yusufkara.cureapi.domain.Job;
import de.yusufkara.cureapi.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("/jobs")
    public Iterable<Job> getJobs() {
        return jobRepository.findAll();
    }

}
