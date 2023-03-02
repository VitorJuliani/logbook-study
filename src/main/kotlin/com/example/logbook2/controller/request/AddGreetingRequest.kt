package com.example.logbook2.controller.request

import com.example.logbook2.controller.response.GreetingResponse.Author

data class AddGreetingRequest(val message: String, val author: Author)
