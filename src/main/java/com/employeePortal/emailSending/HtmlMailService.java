package com.employeePortal.emailSending;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.employeePortal.entity.ProfileInformation;
import com.employeePortal.exceptionHandling.EmployeeNotFoundException;
import com.employeePortal.exceptionHandling.MailSendingException;
import com.employeePortal.repository.ProfileRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
public class HtmlMailService {
	@Value("${spring.mail.username}")
    private String mailUsername;

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private ProfileRepository repository;
    
    Map<String, Object> map=new HashMap<>();

	public ResponseEntity<Map<String, Object>> sendHtmlMail(Long employeeID,String EmailID,String randomNumber) {
		MimeMessage message = mailSender.createMimeMessage();
      MimeMessageHelper helper;
      ProfileInformation entity = this.repository.findById(employeeID).orElseThrow(
    		  ()->new EmployeeNotFoundException("Employee Not found"));
      String EmployeeName=entity.getEmployeeName();

      try {
          helper = new MimeMessageHelper(message, true);
          helper.setFrom(mailUsername);
          helper.setTo(EmailID);
          helper.setSubject("Forgot Password Code");
          String htmlContent = ""
        	        + "\r\n"
        	        + "<div style=\"background-color: #144982; border: 1px solid #ccc; border-radius: 10px; padding: 20px; width: 430px; margin: auto; color: #FFFFFF;\">"
        	        + "    <h2 style=\"text-align: center; text-decoration: underline; color: white;\">One Time Password</h2>"
        	        + "    <p style=\"font-size: medium;\">Hi " + EmployeeName + "</p>\r\n"
        	        + "    <p style=\"font-size: medium;\">To enhance the security of your account, we have implemented Two-Factor Authentication.</p>\r\n"
        	        + "    <p style=\"font-size: medium;\">To ensure it's you, we are providing you with a One-Time Password (OTP) via email for the forgotten password.</p>\r\n"
        	        + "    \r\n"
        	        + "    <p style=\"font-size: medium;\">Please find your OTP below:</p>\r\n"
        	        + "    <p style=\"font-size: large; text-align: center; color: #FFFF;\">OTP: " + randomNumber + "</p>\r\n"
        	        + "    <br>\r\n"
        	        + "    <p style=\"font-size: medium;\">Enter the OTP accurately and within 5 minutes.</p>\r\n"
        	        + "</div>";

          helper.setText(htmlContent, true);

          mailSender.send(message);
          map.put("Message", "Verification code successfully sent to "+EmailID+" this email id.");
          map.put("Status", HttpStatus.OK);
          return ResponseEntity.ok(map);
      } catch (MessagingException e) {
          e.printStackTrace();
          throw new MailSendingException(e.getMessage());
      }
		
	}

	public ResponseEntity<Map<String, Object>> sendWelcomeMail(Long employeeId, String employeName, String emailID,String password,String designation) 
	{
		MimeMessage message = mailSender.createMimeMessage();
	      MimeMessageHelper helper;
	      try {
	          helper = new MimeMessageHelper(message, true);
	          
	          helper.setFrom(mailUsername);
	          helper.setTo(emailID);
	          helper.setSubject("Welcome to Employee portal Your Journey Begins Here!");
	          String htmlContent = ""
	        		    + "\r\n"
	        		    + "<div style=\"background-color: #144982; border: 1px solid #ccc; border-radius: 10px; padding: 20px; width: 430px; margin: auto; color: #FFFFFF;\">"
	        		    + "    <h2 style=\"text-align: center; text-decoration: underline; color: white;\">Welcome to Our Team!</h2>"
	        		    + "    <p style=\"font-size: medium;\">Hi " + employeName + ",</p>\r\n"
	        		    + "    <p style=\"font-size: medium;\">We're thrilled to have you onboard as a "+designation+ ".</p>\r\n"
	        		    + "    <p style=\"font-size: medium;\">Your skills and expertise will be invaluable as we work together to achieve our goals.</p>\r\n"
	        		    + "    \r\n"
	        		    + "    <p style=\"font-size: medium;\">Your login credentials are as follows:</p>\r\n"
	        		    + "    <p style=\"font-size: medium;\">User ID: " + employeeId + "</p>\r\n"
	        		    + "    <p style=\"font-size: medium;\">Password: " + password + "</p>\r\n"
	        		    + "    \r\n"
	        		    + "    <p style=\"font-size: medium;\">If you have any questions or need assistance settling in, don't hesitate to reach out to your manager or colleagues.</p>\r\n"
	        		    + "    <p style=\"font-size: medium;\">Once again, welcome aboard!</p>\r\n"
	        		    + "</div>";


	          helper.setText(htmlContent, true);

	          mailSender.send(message);
	          map.put("Message", "User Details Successfull send to  "+emailID+" this email id.");
	          map.put("Status", HttpStatus.OK);
	          return ResponseEntity.ok(map);
	      } catch (MessagingException e) {
	          e.printStackTrace();
	          throw new MailSendingException(e.getMessage());
	      }
	}


}
