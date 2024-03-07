package com.employeePortal.emailSending;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.employeePortal.exceptionHandling.MailSendingException;

@Service
public class SimpleMailService {

    @Value("${spring.mail.username}")
    private String mailUsername;
    
    Map<String,Object> map=new HashMap<>();

    private final MailSender mailSender;

    @Autowired
    public SimpleMailService(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public ResponseEntity<Map<String, Object>> sendMail(String toAddresses, String fromAddress, String subject, String body) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setSubject(subject);
            mailMessage.setText(body);
            mailMessage.setTo(toAddresses.split(",")); // Split addresses into an array
            mailMessage.setFrom(fromAddress);
            mailSender.send(mailMessage);
            map.put("Message", "Mail sending successfully");
            map.put("Status", HttpStatus.OK);
            map.put("data", "To addresses : "+toAddresses+"\n"+"From addresses : "+fromAddress+"\n"+"Subject : "+subject+"\n"+"Body : "+body);
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MailSendingException(e.getMessage());
        }
    }
}
