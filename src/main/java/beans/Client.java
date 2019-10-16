package beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class Client {
    private String envirinment;
    private int id;
    private String fullName;
    @Value("${greeting}")
    private String greeting;


    public Client(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
    @PreDestroy
    public void destroy(){
        System.out.println(getGreeting());
        System.out.println(getFullName());
    }

    public String getEnvirinment() {
        return envirinment;
    }

    public void setEnvirinment(String envirinment) {
        this.envirinment = envirinment;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}