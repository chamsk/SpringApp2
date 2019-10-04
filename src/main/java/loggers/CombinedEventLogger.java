package loggers;

import beans.Event;

import java.io.IOException;
import java.util.List;

public class CombinedEventLogger implements EventLogger {
    List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) throws IOException {
        //loggers.stream().forEach(EventLogger::logIvent(event));
        for (EventLogger logger: loggers) {
            logger.logEvent(event);
        }
    }
}