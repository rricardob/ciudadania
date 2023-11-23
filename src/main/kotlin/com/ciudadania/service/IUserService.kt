package com.ciudadania.service

import com.ciudadania.model.request.UserRequest
import com.ciudadania.model.response.UserResponse

interface IUserService {

    fun create(userRequest: UserRequest): Long

    fun findById(id: Long): UserResponse

    fun update(id: Long, userRequest: UserRequest): UserResponse?

    fun delete(id: Long)

    fun findAll(): List<UserResponse>

}