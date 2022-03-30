package com.spring.jobrunr.configuration;

import org.jobrunr.configuration.JobRunr;
import org.jobrunr.jobs.mappers.JobMapper;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.server.JobActivator;
import org.jobrunr.storage.InMemoryStorageProvider;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.sql.common.SqlStorageProviderFactory;
import org.jobrunr.storage.sql.postgres.PostgresStorageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JobrunRConfiguration {

    @Bean
    public StorageProvider storageProvider(DataSource dataSource, JobMapper jobMapper) {
        PostgresStorageProvider storageProvider = new PostgresStorageProvider(dataSource);
        storageProvider.setJobMapper(jobMapper);
        return storageProvider;
    }

    /*@Bean
    public JobScheduler initJobRunr(DataSource dataSource, JobActivator jobActivator, JobMapper jobMapper) {
        return JobRunr.configure()
                .useJobActivator(jobActivator)
                .useStorageProvider(storageProvider(dataSource, jobMapper))
                .useBackgroundJobServer()
                .useDashboard()
                .initialize().getJobScheduler();
    }*/
}
