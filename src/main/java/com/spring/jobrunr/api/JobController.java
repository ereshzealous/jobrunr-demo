package com.spring.jobrunr.api;

import com.spring.jobrunr.jobs.SampleJobRequest;
import com.spring.jobrunr.services.SampleJobService;
import org.jobrunr.jobs.JobId;
import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.scheduling.JobRequestScheduler;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;

@RestController
public class JobController {

    private final JobScheduler jobScheduler;
    private final JobRequestScheduler jobRequestScheduler;
    private final SampleJobService sampleService;

    public JobController(JobScheduler jobScheduler, JobRequestScheduler jobRequestScheduler, SampleJobService sampleService) {
        this.jobScheduler = jobScheduler;
        this.jobRequestScheduler = jobRequestScheduler;
        this.sampleService = sampleService;
    }

    @GetMapping("/via-job-lambda/enqueue-example-job")
    public String enqueueExampleViaJobLambda(@RequestParam(value = "name", defaultValue = "World") String name) {
        final JobId enqueuedJobId = jobScheduler.enqueue(() -> sampleService.executeSampleJob("Hello " + name));
        return "Job Enqueued: " + enqueuedJobId.toString();
    }

    @GetMapping("/via-job-request/enqueue-example-job")
    public String enqueueExampleViaJobRequest(@RequestParam(value = "name", defaultValue = "World") String name) {
        final JobId enqueuedJobId = jobRequestScheduler.enqueue(new SampleJobRequest(name));
        return "Job Enqueued: " + enqueuedJobId.toString();
    }

    @GetMapping("/via-job-request/delayed")
    public String scheduleDelayedJob(@RequestParam(name = "duration", defaultValue = "5") Integer duration) {
        final JobId jobId = jobRequestScheduler.schedule(LocalDateTime.now().plusMinutes(duration), new SampleJobRequest("Delayed By => "+ duration));
        return "Job delayed By " + jobId.toString();
    }

}
