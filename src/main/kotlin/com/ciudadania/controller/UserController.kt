package com.ciudadania.controller

import com.ciudadania.entity.commons.Response
import com.ciudadania.model.request.UserRequest
import com.ciudadania.model.response.UserResponse
import com.ciudadania.service.IUserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api/user")
class UserController(val userService: IUserService) {

    @GetMapping("/list-user")
    fun getAllUsers(): ResponseEntity<List<UserResponse>> {
        return ResponseEntity.ok().body(userService.findAll())
    }

    @GetMapping("/find-user-by-id/{id}")
    fun getFindById(@PathVariable("id") id: Long): ResponseEntity<UserResponse> {
        return ResponseEntity.ok().body(userService.findById(id))
    }

    @PutMapping("/update-user/{id}")
    fun updateUser(@PathVariable("id") id: Long,
                       @RequestBody userRequest: UserRequest
    ): ResponseEntity<UserResponse> {
        return ResponseEntity.ok().body(userService.update(id, userRequest))
    }

    @PostMapping
    fun createUser(@RequestBody userRequest: UserRequest): ResponseEntity<Response<Long>> {
        val response = userService.create(userRequest)
        val responseData: Response<Long> = Response<Long>()
        responseData.code = HttpStatus.CREATED.value()
        responseData.message = "Created"
        responseData.bodyOut = response
        return ResponseEntity.created(URI.create("")).body(responseData)
    }

    @DeleteMapping("delete-user/{id}")
    fun deleteById(@PathVariable("id") id: Long): ResponseEntity<Void> {
        userService.delete(id)
        return ResponseEntity.noContent().build();
    }


}