package com.example.logbook2.config

import java.util.UUID
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.zalando.logbook.BodyFilter
import org.zalando.logbook.BodyFilters
import org.zalando.logbook.CorrelationId
import org.zalando.logbook.json.JacksonJsonFieldBodyFilter

@Configuration
class LogbookConfig {

    @Bean
    fun logbookBodyFilter(omittedFieldsProperty: OmittedFieldsProperty): BodyFilter {
        return BodyFilter.merge(
            BodyFilters.defaultValue(),
            JacksonJsonFieldBodyFilter(
                omittedFieldsProperty.omittedFields,
                "***"
            )
        )
    }

    @Bean
    fun correlationId(): CorrelationId {
        return CorrelationId {
            it.headers.getFirst("correlation-id") ?: UUID.randomUUID().toString()
        }
    }
}
