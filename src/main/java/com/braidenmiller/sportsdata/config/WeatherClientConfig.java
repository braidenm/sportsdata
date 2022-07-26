package com.braidenmiller.sportsdata.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(WeatherConfig.class)
@RequiredArgsConstructor
public class WeatherClientConfig {
    private final WeatherConfig weatherConfig;

    @Bean
    public RequestInterceptor requestInterceptorSportsIO() {
        return new ClientCredentialTokenInterceptor(weatherConfig.getApiKey());
    }

    static class ClientCredentialTokenInterceptor implements RequestInterceptor {
        private final String apiKey;

        public ClientCredentialTokenInterceptor(String apiKey) {
            this.apiKey = apiKey;
        }

        @Override
        public void apply(RequestTemplate template) {

            template.query("key", apiKey);
            template.query("contentType", "json");
            template.query("unitGroup", "us");
        }
    }
}
