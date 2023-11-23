package com.ciudadania.repository

import com.ciudadania.entity.ControlTypeModel
import org.springframework.data.jpa.repository.JpaRepository

interface IJpaControlTypeRepository: JpaRepository<ControlTypeModel, Long>