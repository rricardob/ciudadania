package com.ciudadania.mapper

import com.ciudadania.entity.ControlTypeModel
import com.ciudadania.model.request.ControlTypeRequest
import com.ciudadania.model.response.ControlTypeResponse
import org.springframework.stereotype.Component

@Component
class ControlTypeMapper {

    fun asEntity(request: ControlTypeRequest): ControlTypeModel {
        return ControlTypeModel(type = request.type, description = request.description, color = request.color)
    }

    fun asResponse(entity: ControlTypeModel): ControlTypeResponse {
        return ControlTypeResponse(
            id = entity.id,
            type = entity.type,
            description = entity.description,
            color = entity.color
        )
    }

}