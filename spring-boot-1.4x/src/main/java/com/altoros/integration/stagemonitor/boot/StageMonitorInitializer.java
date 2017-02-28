package com.altoros.integration.stagemonitor.boot;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.stagemonitor.core.Stagemonitor;

public class StageMonitorInitializer implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("Monitoring: starting monitor initialization for Spring Boot 1.4x ...");
        Stagemonitor.init();
    }
}