package com.example.logbook2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.boot.context.properties.EnableConfigurationProperties

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties
class Logbook2Application

fun main(args: Array<String>) {
    runApplication<Logbook2Application>(*args)
}
