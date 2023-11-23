package com.ciudadania.entity

import jakarta.persistence.*

@Entity
@Table(name = "position")
data class PositionModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var code: Long = 0L,
    @Column(name = "name", nullable = false, unique = true, length = 100)
    var name: String ="",
    @Column(name = "isActive", columnDefinition = "tinyint default 1", nullable = false)
    var active: Boolean? = true
)