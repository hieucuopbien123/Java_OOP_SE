package dev.lhpnd.graphflow.util;

import dev.lhpnd.graphflow.config.Config;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailUtils {

    public static boolean sendMailImage(String recipient, String sourceImage) {
        System.out.println("Preparing to send email: " + recipient);

        Properties properties = new Properties();

        //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");

        //Your gmail address
        String myAccountEmail = Config.MAIL_ACCOUNT;
        //Your gmail password
        String password = Config.MAIL_PASSWORD;

        //Create a session with account credentials
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        //Prepare email message
        Message message = getMessageImage(session, myAccountEmail, recipient, sourceImage);
        //Send mail
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("Message sent successfully to:" + recipient);
        return  true;
    }

    private static Message getMessageImage(Session session, String myAccountEmail, String recipient, String sourceImage) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("[PROJECT] OOP");
            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();

            String htmlCode = "<!DOCTYPE html>" +
                    "<html lang='en'>" +
                    "<head>" +
                    "<meta http-equiv=\\\"Content-Type\\\" content=\\\"text/html; charset=UTF-8\\\"/>" +
                    "</head>" +
                    "<body>"+
                    "<p> Xin chào <b>" + recipient + "</b>,</p>" +
                    "<img src=\"cid:image\" width=\"40%\" height=\"40%\">"+
                    "<p>---------------------------------------------------</p>" +
                    "<p>Mọi thông tin chi tiết vui lòng liên hệ: Team 1</p>" +
                    "<p>➤ Hotline: 012345678 </p>" +
                    "<p>➤ Email: tu.khongnaudam@gmail.com</p>" +
                    "<p>➤ Lớp : Tài năng KHMT K64</p>" +
                    "</body>" +
                    "</html>";
            messageBodyPart.setContent(htmlCode, "text/html; charset=utf-8");
            // add it
            multipart.addBodyPart(messageBodyPart);

            // second part (the image)
            messageBodyPart = new MimeBodyPart();
            File file = new File(sourceImage);
            DataSource fds = new FileDataSource(file);

            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");

            // add image to the multipart
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            message.setContent(multipart);
            return message;
        } catch (Exception ex) {
            Logger.getLogger(MailUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
