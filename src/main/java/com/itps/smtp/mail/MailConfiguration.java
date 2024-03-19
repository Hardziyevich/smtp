package com.itps.smtp.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class MailConfiguration {

    @Bean
    public JavaMailSenderImpl javaMailSender(Mail mail) {
        log.info("Mail configuration: " + mail.toString());
        final var javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(mail.getHost());
        javaMailSender.setPort(mail.getPort());
        javaMailSender.setPassword(mail.getPassword());
        javaMailSender.setUsername(mail.getUsername());
        final var javaMailProperties = javaMailSender.getJavaMailProperties();
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.smtp.auth", mail.isAuth());
        javaMailProperties.put("mail.smtp.starttls.enable", mail.isStarttls());
        javaMailProperties.put("mail.smtp.starttls.required", mail.isStarttls());
        javaMailProperties.put("mail.smtp.ssl.trust", mail.getHost());
        return javaMailSender;
    }
}
