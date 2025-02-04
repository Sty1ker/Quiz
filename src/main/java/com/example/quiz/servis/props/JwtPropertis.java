package com.example.quiz.servis.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "security.jwt")
public class JwtPropertis {

    private String secret;
    private Long access;
    private Long refresh;

    public String getSecret() {
        return secret;
    }

    public Long getAccess() {
        return access;
    }

    public Long getRefresh() {
        return refresh;
    }


}
