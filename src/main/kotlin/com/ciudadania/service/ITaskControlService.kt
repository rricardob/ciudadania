package com.ciudadania.service

import com.ciudadania.model.TaskControl

fun interface ITaskControlService {

    fun getTaskControlListByDni(dni: Int, year: Int): List<TaskControl>
}