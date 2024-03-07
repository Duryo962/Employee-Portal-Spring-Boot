package com.employeePortal.emailSending;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/mail")
@CrossOrigin("*")
public class MailController {
	@Autowired
    private final SimpleMailService mail;
	@Autowired
	private final HtmlMailService htmlMail;

    @Autowired
    public MailController(SimpleMailService mail) {
        this.mail = mail;
		this.htmlMail = new HtmlMailService();
    }

    @PostMapping("/send")
    public ResponseEntity<Map<String, Object>> sendEmail(@RequestParam String ToAddresses,@RequestParam String fromAddress,@RequestParam String subject,@RequestParam String body ) {
    	System.out.println(ToAddresses);
    	return  mail.sendMail(ToAddresses,fromAddress,subject,body);
        
    }

    @PostMapping("/SendVerificationCode/{employeeId}/{emailID}/{randomNumber}")
    public ResponseEntity<Map<String, Object>> send(@PathVariable Long employeeId, @PathVariable String emailID, @PathVariable String randomNumber) {
        // Your implementation here
        return htmlMail.sendHtmlMail(employeeId, emailID, randomNumber);
    }
    
    @PostMapping("/SendWelcomeMail/{employeeId}/{employeName}/{emailID}/{password}/{designation}")
    public ResponseEntity<Map<String, Object>> sendWelcomeMail(@PathVariable(name = "employeeId") Long employeeId,@PathVariable(name = "employeName") String employeName, @PathVariable(name = "emailID") String emailID, @PathVariable(name = "password") String password,@PathVariable(name = "designation")String designation) {
        return htmlMail.sendWelcomeMail(employeeId,employeName,emailID,password,designation);
    }

}
