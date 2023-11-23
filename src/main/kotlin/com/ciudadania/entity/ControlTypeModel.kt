package com.ciudadania.entity

import jakarta.persistence.*

@Entity
@Table(name = "control_type")
data class ControlTypeModel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0L,
        @Column(name = "type", nullable = false, length = 500)
        var type: String,
        @Column(name = "description", nullable = false, length = 500)
        var description: String,
        @Column(name = "color")
        var color: String
)
