package com.example.taskerapp.damain.repository

import com.example.taskerapp.data.models.TaskModel

interface TaskRepository {

    fun addNewTask(taskModel: TaskModel)

    fun getAllTasks():List<TaskModel>
}