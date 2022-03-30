package com.spring.jobrunr.jobs;

import lombok.RequiredArgsConstructor;
import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.jobrunr.spring.annotations.Recurring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SampleJob {


    private final JobScheduler jobScheduler;


    @Recurring(id = "my-recurring-job", cron = "*/2 * * * *")
    @Job(name = "A recurring job")
    public void recurringJob() throws InterruptedException {
        System.out.println("The recurring job has begun.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Error while executing recurring job => "+ e);
            throw e;
        } finally {
            System.out.println("Recurring job has finished...");
        }
    }
}
