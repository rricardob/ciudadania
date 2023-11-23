package com.ciudadania.repository

import com.ciudadania.entity.PositionModel
import org.springframework.data.jpa.repository.JpaRepository

interface IJpaPositionRepository: JpaRepository<PositionModel, Long> {
}