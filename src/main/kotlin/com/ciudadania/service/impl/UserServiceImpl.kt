package com.ciudadania.service.impl

import com.ciudadania.exception.NotFoundException
import com.ciudadania.mapper.UserMapper
import com.ciudadania.model.request.UserRequest
import com.ciudadania.model.response.UserResponse
import com.ciudadania.repository.IJpaUserRepository
import com.ciudadania.service.IUserService
import org.springframework.stereotype.Repository

@Repository
class UserServiceImpl(
    private val jpaUserRepository: IJpaUserRepository,
    private val userMapper: UserMapper
): IUserService {
    override fun create(userRequest: UserRequest): Long {
        val userModel = userMapper.asEntity(userRequest)

        val saved = jpaUserRepository.save(userModel)

        return saved.id
    }

    override fun findById(id: Long): UserResponse {
        val result = jpaUserRepository.findById(id).orElseThrow { NotFoundException("El usuario con id $id no existe") }
        return userMapper.asResponse(result)
    }

    override fun update(id: Long, userRequest: UserRequest): UserResponse? {

        val exists = jpaUserRepository.findById(id).orElseThrow { NotFoundException("El usuario con id $id no existe") }
        if (exists != null){
            exists.user = userRequest.user
            exists.pass = userRequest.pass
            exists.status = userRequest.status
            exists.rol = userRequest.rol
            return userMapper.asResponse(jpaUserRepository.save(exists))
        }

        return null
    }

    override fun delete(id: Long) {
        jpaUserRepository.deleteById(id)
    }

    override fun findAll(): List<UserResponse> {
        return jpaUserRepository.findAll().map { userMapper.asResponse(it) }
    }
}