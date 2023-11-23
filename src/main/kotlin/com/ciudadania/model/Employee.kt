package com.ciudadania.model

import java.util.*


data class Employee(
    val code: Int,
    val dni: Int,
    val firstLastName: String,
    val secondLastName: String,
    val names: String,
    val birthdate: Date,
    val phone: Int?,
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
