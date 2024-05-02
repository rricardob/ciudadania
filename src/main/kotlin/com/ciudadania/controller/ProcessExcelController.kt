package com.ciudadania.controller

import com.ciudadania.service.IProcessExcel
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@CrossOrigin("*")
@RestController
class ProcessExcelController(val processService: IProcessExcel) {

    @PostMapping(value = ["/api/load-data"])
    fun loadExcelData(
        @Valid @ModelAttribute file: MultipartFile, @RequestParam parameters: Map<*,*>): ResponseEntity<Any> {

        val productResponse = processService.readExcel(file.inputStream, parameters)

        return ResponseEntity.ok().body(productResponse);
    }


}