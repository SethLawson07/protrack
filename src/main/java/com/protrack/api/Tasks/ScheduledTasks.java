package com.protrack.api.Tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.protrack.api.service.AlertService;

@Component
public class ScheduledTasks {
    
    @Autowired
    private AlertService alertService;

    @Scheduled(cron = "0 * * * * *") // Cron expression for running every minute
    public void execute() {
        alertService.create();
    }
}
