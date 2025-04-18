package com.estudos.api_rest.config;

import com.estudos.api_rest.application.usecases.ProductService;
import com.estudos.api_rest.domain.ports.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ProductService productService(
            @Qualifier("productRepositoryImpl") ProductRepository repository
    ) {
        return new ProductService(repository);
    }
}
