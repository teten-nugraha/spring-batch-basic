package id.ten.springbatchbasic.configuration.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

@Slf4j
public class JobCompletionListener extends JobExecutionListenerSupport
{
    @Override
    public void afterJob(JobExecution jobExecution)
    {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED)
        {
            // Log statement
            log.info("BATCH JOB COMPLETED SUCCESSFULLY");
        }
    }
}