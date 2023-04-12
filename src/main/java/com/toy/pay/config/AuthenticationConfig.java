package com.toy.pay.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.toy.pay.security.ReaderIdResolver;

@Configuration
public class AuthenticationConfig implements WebMvcConfigurer {
    private final ReaderIdResolver readerIdResolver;

    public AuthenticationConfig(ReaderIdResolver readerIdResolver) {
        this.readerIdResolver = readerIdResolver;
    }

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(readerIdResolver);
    }
}
