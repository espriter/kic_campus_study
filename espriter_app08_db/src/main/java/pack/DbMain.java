package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DbMain {
	public static void main(String[] args) {
		ApplicationContext context = 
			new ClassPathXmlApplicationContext("init.xml");
		BusinessInter inter = 
				(BusinessInter)context.getBean("businessImpl");
			inter.dataList();
	}
}
