package org.jmresler.studies.kanban.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@EnableBatchProcessing
@Configuration
public class BatchConfiguration {

    private final JobBuilderFactory jobFactory;
    private final StepBuilderFactory stepFactory;

    @Autowired
    public BatchConfiguration(final JobBuilderFactory jobFactory,
                              final StepBuilderFactory stepFactory) {
        this.jobFactory = jobFactory;
        this.stepFactory = stepFactory;
    }

    @Bean
    public Job startJob() {
        return jobFactory.get("batch-job").start(startStep()).next(stopStep()).build();
    }

    @Bean
    public Step stopStep() {
        return stepFactory.get("stop-step").tasklet((contribution, chunkContext) -> {
            log.debug("in step... [stop-step]");
            return RepeatStatus.FINISHED;
        }).build();
    }

    @Bean
    public Step startStep() {
        return stepFactory.get("start-step").tasklet((contribution, chunkContext) -> {
            log.debug("in step... [start-step]");
            return RepeatStatus.FINISHED;
        }).build();
    }
}