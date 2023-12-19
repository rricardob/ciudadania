package com.ciudadania

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class CiudadaniaApplication

fun main(args: Array<String>) {
    //runApplication<CiudadaniaApplication>(*args)
    SpringApplication.run(CiudadaniaApplication::class.java, *args)
}
