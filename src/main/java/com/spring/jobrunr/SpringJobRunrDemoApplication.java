package com.spring.jobrunr;

import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJobRunrDemoApplication {

    @Autowired
    JobScheduler jobScheduler;

    public static void main(String[] args) {

        SpringApplication.run(SpringJobRunrDemoApplication.class, args);
    }

}
