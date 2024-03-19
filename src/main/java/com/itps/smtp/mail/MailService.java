package com.itps.smtp.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSenderImpl javaMailSender;
    private final Mail mail;

    public void send() {
        log.info("Sending mail is kicked off.");
        final var simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("noreply@gmail.com");
        simpleMailMessage.setTo(mail.getTo());
        simpleMailMessage.setSubject("Test mail.");
        simpleMailMessage.setText(":)");
        try {
            javaMailSender.send(simpleMailMessage);
        } catch (Exception exception) {
            log.info("Something went wrong: " + exception.getMessage());
        }
        log.info("Sending mail wrapped up.");
    }
}
