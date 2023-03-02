package com.example.logbook2.exception

import java.time.Instant
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(IllegalStateException::class)
    fun illegalStateExceptionHandler(ex: IllegalStateException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.internalServerError().body(ErrorResponse(ex.localizedMessage))
    }

    data class ErrorResponse(
        val message: String,
        val timestamp: Instant = Instant.now()
    )
}
