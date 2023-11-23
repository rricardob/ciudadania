package com.ciudadania.service.impl

import com.ciudadania.model.TaskControl
import com.ciudadania.repository.IJpaTaskControlRepository
import com.ciudadania.service.ITaskControlService
import org.springframework.stereotype.Repository

@Repository
class TaskControlServiceImpl(
    val jpaTaskControlRepository: IJpaTaskControlRepository
): ITaskControlService {

    override fun getTaskControlListByDni(dni: Int, year: Int, month: Int, controlType: Int): List<TaskControl> {
        val x =  jpaTaskControlRepository.getTaskControlListByDni(dni)
        return  x.map { TaskControl.from(it) }
    }
}