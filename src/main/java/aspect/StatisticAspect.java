package aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
/*
считает, сколько раз был вызван конкретный логгер
 */
@Aspect
public class StatisticAspect {
    private Map<String,Integer> map;

    {
        map = new HashMap<>();
        map.put("ConsoleEventLogger",0);
        map.put("CombinedEventLogger",0);
        map.put("FileEventLogger",0);
        map.put("CacheFileEventLogger",0);
    }


    @Pointcut("execution(* loggers.ConsoleEventLogger.logEvent(..))")
    private void countConsoleEventLogger(){

    }
    @Pointcut("execution(* loggers.CombinedEventLogger.logEvent(..))")
    private void countCombinedEventLogger(){

    }
    @Pointcut("execution(* loggers.FileEventLogger.logEvent(..))")
    private void countFileEventLogger(){

    }
    @Pointcut("execution(* loggers.CacheFileEventLogger.logEvent(..))")
    private void countCacheFileEventLogger(){

    }

    @AfterReturning(pointcut = "countConsoleEventLogger()")
    public void incrementCountConsoleEventLogger(){
        map.put("ConsoleEventLogger",map.get("ConsoleEventLogger")+1);

    }

    @AfterReturning(pointcut = "countCombinedEventLogger()")
    public void incrementCountCombinedEventLogger(){
        int i = map.get("CombinedEventLogger");
        map.put("CombinedEventLogger",map.get("CombinedEventLogger")+1);
    }
    @AfterReturning(pointcut = "countFileEventLogger()")
    public void incrementCountFileEventLogger(){
        int i = map.get("FileEventLogger");
        map.put("FileEventLogger",map.get("FileEventLogger")+1);
    }
    @AfterReturning(pointcut = "countCacheFileEventLogger()")
    public void incrementCountCacheFileEventLogger(){
        int i = map.get("CacheFileEventLogger");
        map.put("CacheFileEventLogger",map.get("CacheFileEventLogger")+1);
    }

    public Map<String, Integer> getMap() {
        return map;
    }




}