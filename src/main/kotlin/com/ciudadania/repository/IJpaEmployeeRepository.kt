package com.ciudadania.repository

import com.ciudadania.entity.EmployeeModel
import org.springframework.data.jpa.repository.JpaRepository

interface IJpaEmployeeRepository: JpaRepository<EmployeeModel, Long> {

    fun findByDni(dni: Int): EmployeeModel
}