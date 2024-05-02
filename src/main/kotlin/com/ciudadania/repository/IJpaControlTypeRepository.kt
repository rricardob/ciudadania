package com.ciudadania.repository

import com.ciudadania.entity.ControlTypeModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface IJpaControlTypeRepository: JpaRepository<ControlTypeModel, Long>{

    fun findByColorAndType(color: String, type: String): Optional<ControlTypeModel>

}