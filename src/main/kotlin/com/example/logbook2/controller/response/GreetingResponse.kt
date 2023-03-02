package com.example.logbook2.controller.response

data class GreetingResponse(
    val message: String
) {

    data class Author(
        val name: String,
        val age: Int
    )

    private val authors = listOf(
        Author("Dunha", 18),
        Author("Dunho", 23),
        Author("Dunhoso", 30)
    )

    val author = authors.random()
}
