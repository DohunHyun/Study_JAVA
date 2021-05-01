package test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new
			ClassPathXmlApplicationContext
				("test04/applicationContext.xml");
		
		Person p = context.getBean("girl",Person.class);
		
		p.makeFood(10,50);
	}
}
