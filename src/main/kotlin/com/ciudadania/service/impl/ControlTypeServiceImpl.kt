package com.ciudadania.service.impl

import com.ciudadania.exception.NotFoundException
import com.ciudadania.mapper.ControlTypeMapper
import com.ciudadania.model.request.ControlTypeRequest
import com.ciudadania.model.response.ControlTypeResponse
import com.ciudadania.repository.IJpaControlTypeRepository
import com.ciudadania.service.IControlTypeService
import com.ciudadania.validation.ValidationUtil
import org.springframework.stereotype.Repository

@Repository
class ControlTypeServiceImpl(
    val jpaControlTypeRepository: IJpaControlTypeRepository,
    val validationUtil: ValidationUtil,
    val controlTypeMapper: ControlTypeMapper
) : IControlTypeService {

    override fun findById(id: Long): ControlTypeResponse {
        val result = jpaControlTypeRepository.findById(id).orElseThrow { NotFoundException("El Tipo de Control con id $id no existe") }
        return  controlTypeMapper.asResponse(result)
    }

    override fun save(controlTypeRequest: ControlTypeRequest): Long {
        val controlTypeModel = controlTypeMapper.asEntity(controlTypeRequest)
        return jpaControlTypeRepository.save(controlTypeModel).id
    }

    override fun update(id: Long, controlTypeRequest: ControlTypeRequest): ControlTypeResponse? {
        val exists = jpaControlTypeRepository.findById(id).orElseThrow { NotFoundException("El Tipo de Control con id $id no existe") }
        if (exists != null){
            exists.type = controlTypeRequest.type
            exists.description = controlTypeRequest.description
            exists.color = controlTypeRequest.color
            return controlTypeMapper.asResponse(jpaControlTypeRepository.save(exists))
        }

        return null

    }

    override fun delete(id: Long) {
        jpaControlTypeRepository.deleteById(id)
    }

    override fun findAll(): List<ControlTypeResponse> {
        return jpaControlTypeRepository.findAll().map { controlTypeMapper.asResponse(it) }
    }


}