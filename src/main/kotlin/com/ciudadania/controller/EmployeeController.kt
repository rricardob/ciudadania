package com.ciudadania.controller

import com.ciudadania.entity.commons.Response
import com.ciudadania.model.request.EmployeeRequest
import com.ciudadania.model.response.EmployeeResponse
import com.ciudadania.service.IEmployeeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employee")
class EmployeeController(val employeeService: IEmployeeService) {

    @GetMapping("/list-employee")
    fun getAllEmployee(): ResponseEntity<List<EmployeeResponse>> {
        return ResponseEntity.ok().body(employeeService.findAll())
    }

    @GetMapping("/find-employee-by-id/{id}")
    fun getFindById(@PathVariable("id") id: Long): ResponseEntity<EmployeeResponse> {
        return ResponseEntity.ok().body(employeeService.findById(id))
    }

    @PutMapping("/update-employee/{id}")
    fun updateEmployee(
        @PathVariable("id") id: Long,
        @RequestBody employeeRequest: EmployeeRequest
    ): ResponseEntity<EmployeeResponse> {
        return ResponseEntity.ok().body(employeeService.update(id, employeeRequest))
    }

    @PostMapping
    fun createUser(@RequestBody employeeRequest: EmployeeRequest): ResponseEntity<Response<Long>> {
        val response = employeeService.create(employeeRequest)
        val responseData: Response<Long> = Response<Long>()
        responseData.code = HttpStatus.CREATED.value()
        responseData.message = "Created"
        responseData.bodyOut = response
        return ResponseEntity.created(URI.create("")).body(responseData)
    }

    @DeleteMapping("delete-user/{id}")
    fun deleteById(@PathVariable("id") id: Long): ResponseEntity<Void> {
        employeeService.delete(id)
        return ResponseEntity.noContent().build();
    }

}