package com.example.spring_app_cleint.configuration;

import com.example.spring_app_cleint.client.EntityModelClient;
import com.example.spring_app_cleint.exception.ClientException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

@Configuration
public class AppConfiguration {
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .defaultStatusHandler(HttpStatusCode::isError, resp ->
                        Mono.just(new ClientException("Exception on request. Status code: " + resp.statusCode().value())))
                .baseUrl("http://localhost:8080/api/v1/model")
                .build();
    }
    @Bean
    public EntityModelClient entityModelClient(WebClient webClient) {
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .build();
        return httpServiceProxyFactory.createClient(EntityModelClient.class);

    }
}