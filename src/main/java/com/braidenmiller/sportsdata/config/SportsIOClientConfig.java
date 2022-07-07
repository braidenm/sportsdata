package com.braidenmiller.sportsdata.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(SportsIOConfig.class)
public class SportsIOClientConfig {
    private final SportsIOConfig sportsIOConfig;

    public SportsIOClientConfig(SportsIOConfig sportsIOConfig) {
        this.sportsIOConfig = sportsIOConfig;
    }

    @Bean
    public RequestInterceptor requestInterceptorSportsIO() {
        return new ClientCredentialTokenInterceptor(sportsIOConfig.getApiKey());
    }

    static class ClientCredentialTokenInterceptor implements RequestInterceptor {
        private final String apiKey;

        public ClientCredentialTokenInterceptor(String apiKey) {
            this.apiKey = apiKey;
        }

        @Override
        public void apply(RequestTemplate template) {
            template.header("Ocp-Apim-Subscription-Key", apiKey);
        }
    }
}
