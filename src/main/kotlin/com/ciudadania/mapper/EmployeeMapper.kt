package com.ciudadania.mapper

import com.ciudadania.entity.EmployeeModel
import com.ciudadania.model.request.EmployeeRequest
import com.ciudadania.model.response.EmployeeResponse
import org.springframework.stereotype.Component


@Component
class EmployeeMapper {

    fun asEntity(request: EmployeeRequest): EmployeeModel {
        return EmployeeModel(
            dni = request.dni,
            code = request.code,
            firstLastName = request.firstLastName,
            secondLastName = request.secondLastName,
            names = request.names,
            birthdate = request.birthdate,
            phone = request.phone!!,
            email = request.email!!,
            address = request.address,
            bloodType = request.bloodType!!,
            photo = request.photo!!,
            supervisor = request.supervisor,
            shortSleeveBlouseOrShirt = request.shortSleeveBlouseOrShirt,
            boxNeckPolo = request.boxNeckPolo,
            pants = request.pants,
            cap = request.cap,
            longSleeveBlouseOrShirt = request.longSleeveBlouseOrShirt,
            reflectiveJacket = request.reflectiveJacket,
            highNeckSweatshirt = request.highNeckSweatshirt,
            vest = request.vest,
            reflectiveWaterproofPoncho = request.reflectiveWaterproofPoncho,
            borceguies = request.borceguies,
            socks = request.socks,
            footwear = request.footwear
        )
    }

    fun asResponse(entity: EmployeeModel): EmployeeResponse {
        return EmployeeResponse(
            dni = entity.dni,
            code = entity.code,
            firstLastName = entity.firstLastName,
            secondLastName = entity.secondLastName,
            names = entity.names,
            birthdate = entity.birthdate,
            phone = entity.phone,
            email = entity.email,
            address = entity.address,
            bloodType = entity.bloodType,
            photo = entity.photo,
            supervisor = entity.supervisor.toString(),
            shortSleeveBlouseOrShirt = entity.shortSleeveBlouseOrShirt,
            boxNeckPolo = entity.boxNeckPolo,
            pants = entity.pants,
            cap = entity.cap,
            longSleeveBlouseOrShirt = entity.longSleeveBlouseOrShirt,
            reflectiveJacket = entity.reflectiveJacket,
            highNeckSweatshirt = entity.highNeckSweatshirt,
            vest = entity.vest,
            reflectiveWaterproofPoncho = entity.reflectiveWaterproofPoncho,
            borceguies = entity.borceguies,
            socks = entity.socks,
            footwear = entity.footwear
        )
    }

}