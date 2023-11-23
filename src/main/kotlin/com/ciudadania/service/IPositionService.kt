package com.ciudadania.service

import com.ciudadania.model.request.PositionRequest
import com.ciudadania.model.response.PositionResponse

interface IPositionService {

    fun create(positionRequest: PositionRequest): Long

    fun findById(id: Long): PositionResponse

    fun update(id: Long, positionRequest: PositionRequest): PositionResponse?

    fun delete(id: Long)

    fun findAll(): List<PositionResponse>

}