package com.ciudadania.model.response

import java.util.*

data class EmployeeResponse(
    val dni: Long,
    val code: Int,
    val firstLastName: String,
    val secondLastName: String,
    val names: String,
    val birthdate: Date? = null,
    val phone: String?,
    val email: String?,
    val address: String,
    val bloodType: String?,
    val photo: String?,
    var supervisor: String?,
    val shortSleeveBlouseOrShirt: String,
    val boxNeckPolo: String,
    val pants: String,
    val cap: String,
    val longSleeveBlouseOrShirt: String,
    val reflectiveJacket: String,
    val highNeckSweatshirt : String,
    val vest: String,
    val reflectiveWaterproofPoncho: String,
    val borceguies: String,
    val socks: String,
    val footwear: String,
)
