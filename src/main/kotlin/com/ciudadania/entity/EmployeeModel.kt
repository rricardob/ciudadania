package com.ciudadania.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "employee")
data class EmployeeModel(
    @Id
    @Column(name = "dni", nullable = false, length = 11)
    var dni: Long = 0L,
    @Column(name = "code", nullable = false, unique = true, length = 10)
    var code: Int = 0,
    @Column(name = "first_last_name", nullable = false, length = 100)
    var firstLastName: String ="",
    @Column(name = "second_last_name", nullable = false, length = 100)
    var secondLastName: String="",
    @Column(name = "names", nullable = false, length = 100)
    var names: String="",
    @Column(name = "birthdate", nullable = false)
    var birthdate: Date? = null,
    @Column(name = "phone", length = 20)
    var phone: Int? = null,
    @Column(name = "email", length = 70)
    var email: String? = null,
    @Column(name = "address", nullable = false, length = 300)
    var address: String? = null,
    @Column(name = "blood_type", length = 20)
    var bloodType: String? = null,
    @Column(name = "photo", length = 100)
    var photo: String? = null,
    @Column(name = "supervisor", nullable = false, length = 11)
    var supervisor: Int? = null,
    @Column(name = "short_sleeve_blouse_or_shirt", length = 5)
    var shortSleeveBlouseOrShirt: String? = null,
    @Column(name = "box_neck_polo", length = 5)
    var boxNeckPolo: String? = null,
    @Column(name = "pants", length = 5)
    var pants: String? = null,
    @Column(name = "cap", length = 5)
    var cap: String? = null,
    @Column(name = "long_sleeve_blouse_or_shirt", length = 5)
    var longSleeveBlouseOrShirt: String? = null,
    @Column(name = "reflective_Jacket", length = 5)
    var reflectiveJacket: String? = null,
    @Column(name = "high_neck_sweatshirt", length = 5)
    var highNeckSweatshirt : String? = null,
    @Column(name = "vest", length = 5)
    var vest: String? = null,
    @Column(name = "reflective_waterproof_poncho", length = 5)
    var reflectiveWaterproofPoncho: String? = null,
    @Column(name = "borceguies", length = 5)
    var borceguies: String? = null,
    @Column(name = "socks", length = 5)
    var socks: String? = null,
    @Column(name = "footwear", length = 5)
    var footwear: String? = null,
    @OneToMany(mappedBy = "employeeModel", fetch = FetchType.LAZY)
    var taskControlModelList: List<TaskControlModel> = emptyList()
)
