package com.example.logbook2.config

import feign.RequestInterceptor
import org.slf4j.MDC
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ClientCorrelationIdInterceptorConfig {

    @Bean
    fun clientCorrelationId(): RequestInterceptor {
        return RequestInterceptor { template ->
            template.header("Correlation-Id", MDC.get("correlation-id"))
        }
    }
}
