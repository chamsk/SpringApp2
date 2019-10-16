package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//@Aspect
public class TestAspect {


    //шаблон
    @Pointcut("execution(* *.logEvent(..))")
    private void allLogEventMethods(){

    }

    @Pointcut("allLogEventMethods() && within(*.*File*Logger)")
    private void logEventInsideFileLoggers(){

    }

    @Pointcut(("execution(* loggers.ConsoleEventLogger.logEvent(..))"))
    private void consoleLoggerMethods(){

    }


    //advice
    //joinPoint - место, где происходит advice
    @Before("allLogEventMethods()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("BEFORE : " + joinPoint.getTarget().getClass().getSimpleName() + " " +
        joinPoint.getSignature().getName());
    }

    //advice после успешного выполнения метода
    //retVal - returt value переменная возвращенная методом на который цепляется аспект
    @AfterReturning(pointcut = "allLogEventMethods()",returning = "retVal")
    public void logAfter(Object retVal){
        System.out.println("Returned value: "+ retVal);
    }

    //advice ожидающий исключение
    @AfterThrowing(pointcut = "allLogEventMethods()",throwing = "exception")
    public void logAfterThrow(Throwable exception){
        System.out.println("throw: " + exception);
    }

    //advice выполняет замещение метода в зависимости от
    //ProceedingJoinPoint может вызвать метод бина, на который привязываемся. proceedingJoinPoint.proceed() - выполняется метод бина
    @Around("consoleLoggerMethods")
    public void aroundLogEvent(ProceedingJoinPoint proceedingJoinPoint){

    }



}