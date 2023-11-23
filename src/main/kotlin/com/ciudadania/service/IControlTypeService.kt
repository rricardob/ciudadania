package com.ciudadania.service

import com.ciudadania.model.request.ControlTypeRequest
import com.ciudadania.model.response.ControlTypeResponse

interface IControlTypeService {

    fun findById(id: Long): ControlTypeResponse

    fun save(controlTypeRequest: ControlTypeRequest): Long

    fun update(id: Long, controlTypeRequest: ControlTypeRequest): ControlTypeResponse?

    fun delete(id: Long)

    fun findAll(): List<ControlTypeResponse>
}