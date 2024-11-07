package com.ecommerce.order.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
public class FeignClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                // 这里假设你已经有一种方式获取 JWT token，例如从 SecurityContext 中
                String jwtToken = "Bearer " + getJwtToken();
                template.header("Authorization", jwtToken);
            }

            private String getJwtToken() {
                // 获取 JWT token 的逻辑，例如从 SecurityContextHolder 中获取
                return SecurityContextHolder.getContext().getAuthentication().getCredentials().toString();
            }
        };
    }
}
