package com.ciudadania.service

import com.ciudadania.model.TaskControl

interface ITaskControlService {

    fun getTaskControlListByDni(dni: Int, year: Int): List<TaskControl>
}