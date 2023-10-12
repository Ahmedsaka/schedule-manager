package io.medalytics.schedulemanager;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ScheduleServiceImpl implements ScheduleService {
    private String SERVICE_NAME = "DEFAULT_SCHEDULE_SERVICE";

    @Override
    public String getScheduleServiceName() {
        return SERVICE_NAME;
    }

    @Scheduled(fixedDelayString = "20000")
    public void jobA(){
        log.info("first jobA works");
    }

    @Scheduled(fixedDelayString = "10000")
    public void jobB(){
        log.info("first jobB works");
    }
}
