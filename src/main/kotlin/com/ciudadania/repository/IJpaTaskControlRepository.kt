package com.ciudadania.repository

import com.ciudadania.entity.TaskControlModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface IJpaTaskControlRepository: JpaRepository<TaskControlModel, Long> {

    @Query("select tc from TaskControlModel tc \n" +
            "join EmployeeModel e on tc.employeeDni = e.dni \n" +
            "where e.dni = :dni ")
    fun getTaskControlListByDni(dni: Int): List<TaskControlModel>

}