package Assignment5_13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("springconf1.xml");

        SBU sbu = (SBU) ac.getBean("sbu3");

        sbu.displayDetails();
    }
}