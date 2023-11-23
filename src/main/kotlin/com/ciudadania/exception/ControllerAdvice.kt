package com.ciudadania.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler
    fun handleCustomException(ex: CustomException): ResponseEntity<ErrorMessage> {
        val errorMessage = ErrorMessage(Date(), ex.httpStatus.toString(), ex.message)
        return ResponseEntity(errorMessage, ex.httpStatus)
    }

}