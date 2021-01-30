package com.ptv.livebox.config.actuator;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * In order to enable httptrace actuator following configuration is required
 *
 * http://localhost:8080/actuator/httptrace
 */
@Configuration
public class HttpTraceActuator {
    @Bean
    public HttpTraceRepository httpTraceRepository() {

        return new InMemoryHttpTraceRepository();
    }
}