package com.spring.jobrunr.jobs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.jobrunr.spring.annotations.Recurring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
@Slf4j
public class SampleJob {


    private final JobScheduler jobScheduler;


    @Recurring(id = "my-recurring-job", cron = "*/1 * * * *")
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

    @Recurring(id = "Test-retry-Recurring-Job", cron = "*/10 * * * *")
    @Job(name = "Retry Recurring Job", retries = 3)
    public void recurringRetryJob() {
        boolean flag = true;
        Integer value = ThreadLocalRandom.current().nextInt(0, 100);
        if (value > 20) {
            throw new RuntimeException("A Random Exception ....");
        } else {
            log.info("Successfully Retried ..... ");
        }
    }
}
