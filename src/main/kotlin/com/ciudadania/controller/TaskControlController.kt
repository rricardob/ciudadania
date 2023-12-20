package com.ciudadania.controller

import com.ciudadania.model.response.TaskControlForEmployeeResponse
import com.ciudadania.model.response.TaskControlResponse
import com.ciudadania.service.IControlTypeService
import com.ciudadania.service.IEmployeeService
import com.ciudadania.service.IPositionService
import com.ciudadania.service.ITaskControlService
import com.ciudadania.utils.Constants
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
@RestController
class TaskControlController(
    val taskControlService: ITaskControlService,
    val employeeService: IEmployeeService,
    val controlTypeService: IControlTypeService,
    val positionService: IPositionService
) {

    @GetMapping(
        value = ["/api/task-control-employee-search"],
        produces = ["application/json"]
    )
    fun search(
        @RequestParam("dni") dni: Int,
        @RequestParam(name = "year", required = false, defaultValue = "-1") year: Int,
        @RequestParam(name = "month", required = false, defaultValue = "-1") month: Int,
        @RequestParam(name = "type-control", required = false, defaultValue = "-1") typeControl: Int
    ): ResponseEntity<TaskControlForEmployeeResponse> {
        val result = taskControlService.getTaskControlListByDni(dni, year, month, typeControl)
        val employee = employeeService.findByDni(dni)
        val supervisor = employee.supervisor?.let { employeeService.findByDni(it.toInt()) }
        if (supervisor != null){
            employee.supervisor = supervisor.names +" "+ supervisor.firstLastName +" "+ supervisor.secondLastName
        }
        if (employee.photo != null && employee.photo != ""){
            employee.photo = Constants.URL_CLOUDINARY+employee.photo
        }

        val x = result.map {
            TaskControlResponse(
                it.id,
                it.controlDate,
                controlTypeService.findById(it.controlTypeId),
                positionService.findById(it.positionId.toLong()).name
            )
        }

        val response = TaskControlForEmployeeResponse.from(employee = employee, taskControlList = x)

        return ResponseEntity.ok().body(response)
    }
}