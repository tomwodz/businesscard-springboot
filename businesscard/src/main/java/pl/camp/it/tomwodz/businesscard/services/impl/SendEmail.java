package pl.camp.it.tomwodz.businesscard.services.impl;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.springframework.stereotype.Service;
import pl.camp.it.tomwodz.businesscard.model.Email;
import pl.camp.it.tomwodz.businesscard.services.ISendEmail;

import java.util.Properties;

@Service
public class SendEmail implements ISendEmail {
    public void sendEmail(Email email) {

        try {
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", true);
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", "serwer2361510.home.pl");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.ssl.trust", "serwer2361510.home.pl");

            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("form@serwer2361510.home.pl", "Testtest11!");
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("form@serwer2361510.home.pl"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(email.getEmailRecipient()));
            message.setSubject(email.getEmailSubject());

            String head = new StringBuilder().
                    append("Autor: ").
                    append(email.getEmailAuthor()).
                    append(" e-mail: ").
                    append(email.getEmailAuthorAddressEmail()).
                    append(" Treść: ").
                    toString();

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(head +
                    email.getEmailContent(), "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);
        }

        catch (MessagingException e){
        }
    }


}
