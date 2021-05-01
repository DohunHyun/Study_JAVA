package test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new
			ClassPathXmlApplicationContext
				("test03/applicationContext.xml");
		
		Person p = context.getBean("boy",Person.class);
		
		p.makeFood();
	}
}
