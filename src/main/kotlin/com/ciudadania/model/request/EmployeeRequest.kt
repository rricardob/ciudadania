package com.ciudadania.model.request

import java.util.*

data class EmployeeRequest(
    val dni: Long,
    val code: Int,
    val firstLastName: String,
    val secondLastName: String,
    val names: String,
    val birthdate: Date,
    val phone: String?,
    val email: String?,
    val address: String,
    val bloodType: String?,
    val photo: String?,
    val supervisor: Int,
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
    val footwear: String
)
