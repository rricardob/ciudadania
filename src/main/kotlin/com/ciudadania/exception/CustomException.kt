package com.ciudadania.exception

import org.springframework.http.HttpStatus

open class CustomException(
    message: String, val httpStatus: HttpStatus
) : Exception(message)