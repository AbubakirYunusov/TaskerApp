package com.example.taskerapp.damain.use_cases

import com.example.taskerapp.damain.repository.TaskRepository
import com.example.taskerapp.data.models.TaskModel


class GetAllTaskUseCaseImpl(
    private val addNewTaskRepository: TaskRepository,
    ) : GetAllTaskUseCas {
    override fun getAllTasks(): List<TaskModel> {
        return addNewTaskRepository.getAllTasks()
    }

}