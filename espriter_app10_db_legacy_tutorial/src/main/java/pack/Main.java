	package pack;
	
	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;
	
	public class Main {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			ApplicationContext context =
					new ClassPathXmlApplicationContext("init.xml");
			
			BusinessInter inter = 
					(BusinessInter)context.getBean("businessImpl");
			inter.sangShow();
	
		}
	
	}
