package com.example.taskerapp.damain.use_cases

import com.example.taskerapp.data.models.TaskModel

interface AddNewTaskUseCase {

    fun addNewTask(taskModel: TaskModel)
}