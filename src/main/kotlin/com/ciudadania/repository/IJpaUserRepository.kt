package com.ciudadania.repository

import com.ciudadania.entity.UserModel
import org.springframework.data.jpa.repository.JpaRepository

interface IJpaUserRepository: JpaRepository<UserModel, Long> {
}