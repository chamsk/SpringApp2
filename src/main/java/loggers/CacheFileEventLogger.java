package loggers;

import beans.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;


    public CacheFileEventLogger(String filename,int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<>();
    }


      public void destroy() {
        if(!(cache.isEmpty())) writeEventsFromCache(cache);
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if(cache.size()==cacheSize){
            writeEventsFromCache(cache);
            cache.clear();
        }
    }

    public void writeEventsFromCache(List<Event> cache)  {
        for (Event e:cache) {
            super.logEvent(e);
        }
        //cache.stream().forEach(super::logEvent);

    }
}