package com.example.logbook2.controller

import com.example.logbook2.client.GreetingsClient
import com.example.logbook2.controller.request.AddGreetingRequest
import com.example.logbook2.controller.response.GreetingResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/greetings")
class GreetingsController(
    private val client: GreetingsClient
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @GetMapping
    fun getGreeting(): ResponseEntity<GreetingResponse> =
        ResponseEntity.ok(GreetingResponse("Hello World!"))

    @PostMapping
    fun addGreeting(@RequestBody addGreetingRequest: AddGreetingRequest): ResponseEntity<GreetingResponse> =
        ResponseEntity
            .status(HttpStatus.CREATED)
            .body(GreetingResponse(addGreetingRequest.message))

    @GetMapping("/remote")
    fun getRemoteGreeting(): ResponseEntity<GreetingResponse> =
        client.getGreeting()
            .let(::GreetingResponse)
            .let { ResponseEntity.ok(it) }
            .also { log.info("Remote greeting fetched") }

    @GetMapping("/failure")
    fun getGreetingFailure(): ResponseEntity<Unit> {
        client.getGreetingError()
        return ResponseEntity.ok(Unit)
    }
}
