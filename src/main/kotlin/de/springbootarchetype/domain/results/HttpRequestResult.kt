package de.springbootarchetype.domain.results

import de.springbootarchetype.enums.Outcome
import org.springframework.http.HttpStatus
 
open class HttpRequestResult(outcome: Outcome, message: String, var httpStatus: HttpStatus) : MessageResult(outcome, message)