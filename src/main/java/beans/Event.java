package beans;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private int id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    public static Boolean isDay(int start, int end){
        LocalTime time = LocalTime.now();
        return  time.getHour()>start&&time.getHour()<end;

    }


    public Event(Date date, DateFormat dateFormat) {
        id = AUTO_ID.getAndIncrement();

        this.date = date;
        this.dateFormat = dateFormat;
    }

    public Date getDate() {
        return date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "beans.Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}