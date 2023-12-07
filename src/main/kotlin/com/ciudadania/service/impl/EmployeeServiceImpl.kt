package com.ciudadania.service.impl

import com.ciudadania.exception.NotFoundException
import com.ciudadania.mapper.EmployeeMapper
import com.ciudadania.model.request.EmployeeRequest
import com.ciudadania.model.response.EmployeeResponse
import com.ciudadania.repository.IJpaEmployeeRepository
import com.ciudadania.service.IEmployeeService
import org.springframework.stereotype.Repository

@Repository
class EmployeeServiceImpl(
    val employeeRepository: IJpaEmployeeRepository,
    val employeeMapper: EmployeeMapper): IEmployeeService {

    override fun findByDni(dni: Int): EmployeeResponse {
        val obj = employeeRepository.findByDni(dni.toLong())
        if (obj.isEmpty) throw NotFoundException("Employee not found")
        return employeeMapper.asResponse(obj.get())
    }

    override fun create(employeeRequest: EmployeeRequest): Long {
        val employeeModel = employeeMapper.asEntity(employeeRequest)

        val saved = employeeRepository.save(employeeModel)

        return saved.dni
    }

    override fun findById(id: Long): EmployeeResponse {
        val response = employeeRepository.findById(id).orElseThrow { NotFoundException("El trabajador con id $id no existe") }
        return employeeMapper.asResponse(response)
    }

    override fun update(id: Long, employeeRequest: EmployeeRequest): EmployeeResponse? {
        val exists = employeeRepository.findById(id)
        if (exists.isPresent){
            exists.get().code = employeeRequest.code
            exists.get().firstLastName = employeeRequest.firstLastName
            exists.get().secondLastName = employeeRequest.secondLastName
            exists.get().names = employeeRequest.names
            exists.get().birthdate = employeeRequest.birthdate
            exists.get().phone = employeeRequest.phone!!
            exists.get().email = employeeRequest.email!!
            exists.get().address = employeeRequest.address
            exists.get().bloodType = employeeRequest.bloodType!!
            exists.get().photo = employeeRequest.photo!!
            exists.get().supervisor = employeeRequest.supervisor
            exists.get().shortSleeveBlouseOrShirt = employeeRequest.shortSleeveBlouseOrShirt
            exists.get().boxNeckPolo = employeeRequest.boxNeckPolo
            exists.get().pants = employeeRequest.pants
            exists.get().cap = employeeRequest.cap
            exists.get().longSleeveBlouseOrShirt = employeeRequest.longSleeveBlouseOrShirt
            exists.get().reflectiveJacket = employeeRequest.reflectiveJacket
            exists.get().highNeckSweatshirt = employeeRequest.highNeckSweatshirt
            exists.get().vest = employeeRequest.vest
            exists.get().reflectiveWaterproofPoncho = employeeRequest.reflectiveWaterproofPoncho
            exists.get().borceguies = employeeRequest.borceguies
            exists.get().socks = employeeRequest.socks
            exists.get().footwear = employeeRequest.footwear

            return employeeMapper.asResponse(employeeRepository.save(exists.get()))
        }
        return null
    }

    override fun delete(id: Long) {
        employeeRepository.deleteById(id)
    }

    override fun findAll(): List<EmployeeResponse> {
        return employeeRepository.findAll().map { employeeMapper.asResponse(it) }
    }
}