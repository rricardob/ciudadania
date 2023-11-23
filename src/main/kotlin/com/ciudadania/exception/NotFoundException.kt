package com.ciudadania.exception

import org.springframework.http.HttpStatus

class NotFoundException(message: String) :
    CustomException(message, HttpStatus.CONFLICT)