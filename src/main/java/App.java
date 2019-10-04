import beans.Client;
import beans.EventType;
import beans.Event;
import loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

public class App {
    private Client client;
    private EventLogger defaultLogger;
    Map<EventType,EventLogger> map;

    public App(Client client,EventLogger defaultLogger, Map<EventType,EventLogger> map) {
        this.client = client;
        this.map = map;
        this.defaultLogger = defaultLogger;
    }

    public void logEvent(Event event, String msg, EventType type) throws IOException {
        String message = msg.replaceAll(String.valueOf(client.getId()),client.getFullName());
        event.setMsg(message);

       EventLogger logger = map.get(type);
        if(logger == null){
            logger = defaultLogger;
        }


        logger.logEvent(event);


    }


    public static void main(String[] args) throws IOException {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        App app = context.getBean("App",App.class);
        Event event = context.getBean(Event.class);
        app.logEvent( event, "Some event for 1" ,EventType.INFO);

        event = context.getBean(Event.class);
        app.logEvent( event, "Some event for 2", EventType.ERROR);

        event = context.getBean(Event.class);
        app.logEvent(event,"Some event for 3", null);

        context.close();
    }
}