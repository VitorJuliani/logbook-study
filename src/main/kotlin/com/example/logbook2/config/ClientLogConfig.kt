package com.example.logbook2.config

import feign.Logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.zalando.logbook.Logbook
import org.zalando.logbook.openfeign.FeignLogbookLogger

@Configuration
class ClientLogConfig {

    @Bean
    fun feignLogInterceptor(logbook: Logbook): Logger = FeignLogbookLogger(logbook)

    @Bean
    fun feignLogLevel(): Logger.Level = Logger.Level.FULL
}
