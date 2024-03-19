package com.itps.smtp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import com.itps.smtp.mail.MailService;

@ConfigurationPropertiesScan
@SpringBootApplication
public class SmtpApplication {

	public static void main(String[] args) {
		final var run = SpringApplication.run(SmtpApplication.class, args);
		final var bean = run.getBean(MailService.class);
		bean.send();
	}

}
