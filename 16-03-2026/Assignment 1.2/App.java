package Assignment5_12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	ApplicationContext ac=new ClassPathXmlApplicationContext("springconf.xml");

        
        Employee e=(Employee) ac.getBean("emp1");
        
        e.getSbuDetails();
    }
}