package org.softuni.mobilele.service.scheduling;

import org.softuni.mobilele.service.UserActivationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ActivationLinkCleanupScheduler {

    private final UserActivationService userActivationService;

    public ActivationLinkCleanupScheduler(UserActivationService userActivationService) {
        this.userActivationService = userActivationService;
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void cleanUp() {
        System.out.println("Trigger clean up activation links." + LocalDateTime.now());
        userActivationService.cleanUpObsoleteActivationLinks();
    }

}
