package com.ciudadania.entity

import com.ciudadania.enums.Rol
import jakarta.persistence.*

@Entity
@Table(name = "users")
class UserModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    @Column(name = "user", nullable = false, length = 40)
    var user: String,
    @Column(name = "pass", nullable = false, length = 20)
    var pass: String,
    @Column(name = "status", nullable = false)
    var status: Boolean,
    @Column(name = "rol", nullable = false, length = 100)
    @Enumerated(EnumType.STRING)
    var rol: Rol
)