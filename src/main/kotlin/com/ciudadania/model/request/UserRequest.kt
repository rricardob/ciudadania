package com.ciudadania.model.request

import com.ciudadania.enums.Rol

data class UserRequest(
    val user: String,
    val pass: String,
    val status: Boolean,
    val rol: Rol
)