package com.ciudadania.entity.commons

data class Response<T>(
    var bodyOut: T? = null,
    var message: String? = null,
    var code: Int? = null
)

