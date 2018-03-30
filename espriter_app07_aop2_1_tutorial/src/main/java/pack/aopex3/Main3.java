package pack.aopex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main3 {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("initaop3.xml");
		
		LogicInter inter = (LogicInter)context.getBean("logicImpl");
		inter.selectdata_process();

	}

}
