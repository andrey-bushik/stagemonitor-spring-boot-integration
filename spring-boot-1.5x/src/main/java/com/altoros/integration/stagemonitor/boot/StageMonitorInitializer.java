package com.altoros.integration.stagemonitor.boot;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.stagemonitor.core.Stagemonitor;

public class StageMonitorInitializer implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("Monitoring: starting monitor initialization for Spring Boot 1.5x ...");
        Stagemonitor.init();
    }
}