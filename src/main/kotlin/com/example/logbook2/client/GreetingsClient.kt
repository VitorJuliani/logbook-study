package com.example.logbook2.client

import com.example.logbook2.config.ClientCorrelationIdInterceptorConfig
import com.example.logbook2.config.ClientLogConfig
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(
    name = "greetings-client",
    url = "http://localhost:8081/api/v1/greetings",
    configuration = [ClientLogConfig::class, ClientCorrelationIdInterceptorConfig::class]
)
interface GreetingsClient {

    @GetMapping
    fun getGreeting(): String
}
