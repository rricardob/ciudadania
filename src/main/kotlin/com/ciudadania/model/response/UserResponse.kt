package com.ciudadania.model.response

import com.ciudadania.enums.Rol

data class UserResponse(
    var id: Long,
    var user: String,
    var pass: String,
    var status: Boolean,
    var rol: Rol
)