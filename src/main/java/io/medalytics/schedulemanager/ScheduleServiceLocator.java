package io.medalytics.schedulemanager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class ScheduleServiceLocator {
    private final Map<String, ScheduleService> scheduleServiceCache = new ConcurrentHashMap<>();

    @Autowired
    public void setScheduleServiceCache(List<ScheduleService> serviceList) {
        log.info("populating schedule service cache");
        serviceList.forEach(service -> scheduleServiceCache.put(service.getScheduleServiceName(), service));
    }

    public ScheduleService getServiceByName(String serviceName) {
        if (!scheduleServiceCache.containsKey(serviceName)) {
            log.error("Invalid service {}", serviceName);
            throw new ScheduleServiceException("Invalid service %s".formatted(serviceName));
        }
        return scheduleServiceCache.get(serviceName);
    }
}
