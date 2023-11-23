package com.ciudadania.service.impl

import com.ciudadania.exception.NotFoundException
import com.ciudadania.mapper.PositionMapper
import com.ciudadania.model.request.PositionRequest
import com.ciudadania.model.response.PositionResponse
import com.ciudadania.repository.IJpaPositionRepository
import com.ciudadania.service.IPositionService
import com.ciudadania.validation.ValidationUtil
import org.springframework.stereotype.Repository

@Repository
class PositionServiceImpl(
    private val jpaPositionRepository: IJpaPositionRepository,
    private val validationUtil: ValidationUtil,
    private val positionMapper: PositionMapper
) : IPositionService {

    override fun create(positionRequest: PositionRequest): Long {
        validationUtil.validate(positionRequest)

        val positionModel = positionMapper.asEntity(positionRequest)

        val x = jpaPositionRepository.save(positionModel)

        return x.code
    }

    override fun findById(id: Long): PositionResponse {
        val result = jpaPositionRepository.findById(id).orElseThrow { NotFoundException("La Funcion con id $id no existe") }
        return positionMapper.asResponse(result)
    }

    override fun update(id: Long, positionRequest: PositionRequest): PositionResponse? {
        validationUtil.validate(positionRequest)
        val exists = jpaPositionRepository.findById(id).orElseThrow { NotFoundException("La Funcion con id $id no existe") }
        if (exists != null){
            exists.name = positionRequest.name
            exists.active = positionRequest.active
            return positionMapper.asResponse(jpaPositionRepository.save(exists))
        }

        return null
    }

    override fun delete(id: Long) {
        jpaPositionRepository.deleteById(id)
    }

    override fun findAll(): List<PositionResponse> {
        val result = jpaPositionRepository.findAll()
        return result.map { positionMapper.asResponse(it) }
    }
}