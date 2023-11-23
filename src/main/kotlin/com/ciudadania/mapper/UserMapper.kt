package com.ciudadania.mapper

import com.ciudadania.entity.UserModel
import com.ciudadania.model.request.UserRequest
import com.ciudadania.model.response.UserResponse
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun asEntity(request: UserRequest): UserModel {
        return UserModel(user = request.user, pass = request.pass, status = request.status, rol = request.rol)
    }

    fun asResponse(entity: UserModel): UserResponse {
        return UserResponse(
            id = entity.id,
            user = entity.user,
            pass = entity.pass,
            status = entity.status,
            rol = entity.rol
        )
    }
}