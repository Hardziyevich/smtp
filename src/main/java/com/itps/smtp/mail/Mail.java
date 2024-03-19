package com.itps.smtp.mail;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ConfigurationProperties(prefix = "mail")
@Getter
@ConstructorBinding
@RequiredArgsConstructor
@ToString
public class Mail {
    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private final boolean auth;
    private final boolean starttls;
    private final String to;
}
