package org.compain.library.service;

import org.compain.library.service.DTO.UserLateBorrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MailService {

    @Autowired
    public JavaMailSender emailSender;

    public MailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendMailForLateBorrowing(UserLateBorrowing userLateBorrowing) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        String text = "<p>Bonjour " + userLateBorrowing.getFirstname() + ",</p> "+
                "<p> Nous sommes toujours dans l'attente de restitution des livres suivants: </p>";
        List<UserLateBorrowing.LateBorrowing> bookList = userLateBorrowing.getLateBorrowingList();
        for (int i=0; i<bookList.size(); i++) {
            text = text +
                    "<p>- " + bookList.get(i).getTitle() + " de " + bookList.get(i).getAuthor() + " dont la date limite de retour etait au " + bookList.get(i).getBorrowing_limit_date().format(formatter) + "</p>";
        }
        text = text + "<p> Merci de nous les restituer le plus rapidement possible.</p>" +
                "<p>Cordialement,</p>" +
                "<p>Service retour de la bibliothèque de Polis. </p>";

        message.setContent(text, "text/html");
        helper.setTo(userLateBorrowing.getEmail());
        helper.setSubject("Retard restitution emprunt bibliothèque");

        this.emailSender.send(message);
    }

}
