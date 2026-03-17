package Assignment5_11;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("springconf.xml");
		Employee e1 = (Employee) ac.getBean("emp1");
		e1.show();
	}
}