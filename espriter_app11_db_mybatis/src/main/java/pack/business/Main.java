package pack.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context =
				new ClassPathXmlApplicationContext("init.xml");
		
		ProcessInter inter =
				(ProcessInter)context.getBean("processImpl");
		inter.dataShow();

	}

}
