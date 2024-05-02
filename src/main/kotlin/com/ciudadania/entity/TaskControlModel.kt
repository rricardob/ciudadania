package com.ciudadania.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "task_control")
data class TaskControlModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,
    @Column(name = "employee_dni", nullable = false, length = 10)
    var employeeDni: Long = 0L,
    @Column(name = "control_date", nullable = false)
    var controlDate: LocalDate? = null,
    @Column(name = "control_type_id", nullable = false)
    var controlTypeId: Long = 0L,
    @Column(name = "position_id", nullable = false)
    var positionId: Long = 0L,
    @ManyToOne
    @JoinColumn(name = "employee_dni", insertable = false, updatable = false)
    var employeeModel: EmployeeModel? = null,
    @ManyToOne
    @JoinColumn(name = "control_type_id", insertable = false, updatable = false)
    var controlTypeModel: ControlTypeModel? = null,
    @ManyToOne
    @JoinColumn(name = "position_id", insertable = false, updatable = false)
    var positionModel: PositionModel? = null
)
