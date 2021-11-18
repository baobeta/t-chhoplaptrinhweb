package com.example.techshop.utils;

import static com.example.techshop.common.CoreConstant.MAIL_SENDER;
import static com.example.techshop.common.CoreConstant.PASS_MAIL_SENDER;

import com.example.techshop.entity.OrderDetailEntity;
import com.example.techshop.entity.OrderItemEntity;
import java.util.List;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import com.example.techshop.common.CoreConstant.*;


public class MailUtils {
  private String userEmail;
  public MailUtils(String userEmail) {
    this.userEmail = userEmail;
  }
  public void sendMail(String content){
    String emailSender = MAIL_SENDER;
    String password  = PASS_MAIL_SENDER;
    Properties properties = this.propertiesMail();

    Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator(){
      protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(emailSender,password);
      }
    });

    try{
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(emailSender));
      message.addRecipient(Message.RecipientType.TO,new InternetAddress(userEmail));
      message.setSubject("XÁC NHẬN ĐƠN HÀNG","utf-8");
      message.setContent(content, "text/html; charset=utf-8");
      Transport.send(message);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private Properties propertiesMail(){
    Properties properties = new Properties();

    properties.put("mail.smtp.auth",true);
    properties.put("mail.smtp.starttls.enable",true);
    properties.put("mail.smtp.host","smtp.gmail.com");
    properties.put("mail.smtp.port","587");
    properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
    return properties;
  }

//  public void sendMaiRegister(){
//    String token = TokenUltils.getToken(useremail);
//    String LinkSending = WEB_URL+"/ActiveAccount?key="+token;
//    String content = "<h1>Vertication Link....</h1></br>" +
//        "<b >Your Verification Link:</b> "+LinkSending;
//    sendMail(LinkSending);
//  }
//  public void sendMaiForget(String password){
//    String token = TokenUltils.getToken(useremail);
//    String hashPassword = TokenUltils.getToken(password);
//    String LinkSending = WEB_URL+"/forgetpass?mail="+token+"&newpass="+hashPassword;
//    String content = "<h1>Confirm new password Link....</h1></br>" +
//        "<b >Your Verification to change Password Link:</b> "+LinkSending;
//    sendMail(LinkSending);
//  }

}
