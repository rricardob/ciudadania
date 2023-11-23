package com.ciudadania.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "task_control")
data class TaskControlModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "employee_dni", nullable = false, length = 10)
    var employeeDni: Long,
    @Column(name = "control_date", nullable = false)
    var controlDate: LocalDate,
    @Column(name = "control_type_id", nullable = false)
    var controlTypeId: Long,
    @Column(name = "position_id", nullable = false)
    var positionId: Long,
    @ManyToOne
    @JoinColumn(name = "employee_dni", insertable = false, updatable = false)
    var employeeModel: EmployeeModel,
    @ManyToOne
    @JoinColumn(name = "control_type_id", insertable = false, updatable = false)
    var controlTypeModel: ControlTypeModel?,
    @ManyToOne
    @JoinColumn(name = "position_id", insertable = false, updatable = false)
    var positionModel: PositionModel
)
