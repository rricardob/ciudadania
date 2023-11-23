package com.ciudadania.controller

import com.ciudadania.entity.commons.Response
import com.ciudadania.service.IProcessExcel
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.InputStream

@RestController
class ProcessExcelController(val processService: IProcessExcel) {

    @GetMapping(
        value = ["/api/process-control-type"],
        produces = ["application/json"]
    )
    fun createProduct(): ResponseEntity<Void> {
        val productResponse = processService.readExcel(InputStream.nullInputStream())
        return ResponseEntity.ok().build()
    }

    @PostMapping(value = ["/api/load-data"])
    fun loadExcelData(
        @Valid @ModelAttribute file: MultipartFile): ResponseEntity<Response<String>?> {

        val productResponse = processService.readExcel(file.inputStream)

        return ResponseEntity.ok().build();
    }


}