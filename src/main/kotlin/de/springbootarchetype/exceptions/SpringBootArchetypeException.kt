package de.springbootarchetype.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
class SpringBootArchetypeException : Exception {
    override var message: String?

    constructor(message: String) : super(message) {
        this.message = message
    }

    constructor(message: String, throwable: Throwable?) : super(message, throwable) {
        this.message = message
    }

    override fun toString(): String {
        return "SpringBootArchetypeException(message=$message)"
    }

}