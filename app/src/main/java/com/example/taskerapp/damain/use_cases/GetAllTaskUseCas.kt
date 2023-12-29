package com.example.taskerapp.damain.use_cases

import com.example.taskerapp.data.models.TaskModel

interface GetAllTaskUseCas {
    fun getAllTasks(): List<TaskModel>
}