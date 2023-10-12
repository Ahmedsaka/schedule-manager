package io.medalytics.schedulemanager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

public interface ScheduleService {
    String getScheduleServiceName();
}
