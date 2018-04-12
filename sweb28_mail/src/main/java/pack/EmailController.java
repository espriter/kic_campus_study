package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmailController {
		
		@Autowired
		private EmailSender emailSender;
			
		@RequestMapping(value="send",method=RequestMethod.GET)
		public String formback() {
			return "mailform";
		}
		
		
		@RequestMapping(value="send",method=RequestMethod.POST)
		public String submit(EmailForm form) throws Exception{
			emailSender.sendEmail(form);
			return "success";
		}
		
		
		
}
