package com.ciudadania.repository

import com.ciudadania.entity.EmployeeModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface IJpaEmployeeRepository: JpaRepository<EmployeeModel, Long> {

    fun findByDni(dni: Long): Optional<EmployeeModel>
}