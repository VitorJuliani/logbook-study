package com.example.logbook2.config

import feign.RequestInterceptor
import java.util.UUID
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ClientCorrelationIdInterceptorConfig {

    @Bean
    fun clientCorrelationId(): RequestInterceptor {
        return RequestInterceptor { template ->
            template.header("Correlation-Id", UUID.randomUUID().toString())
        }
    }
}
