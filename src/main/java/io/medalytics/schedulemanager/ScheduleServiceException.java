package io.medalytics.schedulemanager;

public class ScheduleServiceException extends RuntimeException {
    public ScheduleServiceException(String message) {
        super(message);
    }

    public ScheduleServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
