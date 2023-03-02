package com.example.logbook2.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "log")
data class OmittedFieldsProperty(
    var omittedFields: Set<String> = emptySet()
)
