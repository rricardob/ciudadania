package com.ciudadania.mapper

import com.ciudadania.entity.PositionModel
import com.ciudadania.model.request.PositionRequest
import com.ciudadania.model.response.PositionResponse
import org.springframework.stereotype.Component

@Component
class PositionMapper {
    fun asEntity(request: PositionRequest): PositionModel {
        return PositionModel(name = request.name, active = request.active)
    }

    fun asResponse(entity: PositionModel): PositionResponse {
        return PositionResponse(
            code = entity.code,
            name = entity.name,
            active = entity.active
        )
    }
}