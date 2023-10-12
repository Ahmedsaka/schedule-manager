package io.medalytics.schedulemanager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduledAnnotationBeanPostProcessor processor;
    private final ScheduleService scheduleService;

    @PostMapping("/stop")
    public String stop(){
        processor.postProcessBeforeDestruction(scheduleService, "");
        log.info("Stopped schedule");
        return "OK";
    }

    @PostMapping("/start")
    public String start(){
        processor.postProcessAfterInitialization(scheduleService, "");
        log.info("Start schedule");
        return "OK";
    }
}
