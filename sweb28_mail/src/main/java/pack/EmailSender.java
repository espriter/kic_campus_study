package pack;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.JavaMailSender;

@Component
public class EmailSender {
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(EmailForm emailFomr) throws Exception{
		//메일 발송 기능 제공
		MimeMessage msg = mailSender.createMimeMessage();
		msg.setSubject(emailFomr.getSubject()); //메일 제목
		msg.setText(emailFomr.getContent());
		msg.setRecipient(RecipientType.TO, new InternetAddress(emailFomr.getReceiver()));
		mailSender.send(msg);
	}
}
