package com.ciudadania.exception

import java.util.*

data class ErrorMessage(
    private val timestamp: Date?,
    val code: String,
    val message: String?
)