package org.aoto.tools.mail.example;

import org.aoto.tools.mail.JavaMail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/mail")
public class MailExample {

	@RequestMapping(value = "/sendMail")
	public void panel() {
		/* SpringSendMail mail = new SpringSendMail();
		 mail.sendMail();*/
		 JavaMail mail = new JavaMail();
		 mail.sendMail();
	}
}
