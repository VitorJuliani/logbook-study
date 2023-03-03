package com.example.logbook2.filter

import java.lang.Exception
import java.util.UUID
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.slf4j.MDC
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Component
class CorrelationIdInterceptor : HandlerInterceptor {

    private val correlationIdHeaderName = "correlation-id"
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val correlationId = request.getHeader(correlationIdHeaderName)
            ?: UUID.randomUUID().toString()

        MDC.put(correlationIdHeaderName, correlationId)

        response.addHeader(correlationIdHeaderName, correlationId)

        return true
    }

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        MDC.clear()
    }
}

@Component
class ConfigInterceptor(
    private val correlationIdInterceptor: CorrelationIdInterceptor
) : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(correlationIdInterceptor)
    }
}
