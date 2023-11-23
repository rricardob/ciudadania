package com.ciudadania.model.response

data class TaskControlForEmployeeResponse(
    val employee: EmployeeResponse,
    val taskControlList: List<TaskControlResponse>
) {
    companion object {
        fun from(
            taskControlList: List<TaskControlResponse>,
            employee: EmployeeResponse
        ) = TaskControlForEmployeeResponse(
            employee = employee,
            taskControlList = taskControlList
        )

    }
}
