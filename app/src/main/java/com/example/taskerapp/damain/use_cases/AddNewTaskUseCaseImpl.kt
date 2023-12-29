package com.example.taskerapp.damain.use_cases

import com.example.taskerapp.damain.repository.TaskRepository
import com.example.taskerapp.data.models.TaskModel

class AddNewTaskUseCaseImpl(
    private val addNewTaskRepository: TaskRepository,
) : AddNewTaskUseCase {

    override fun addNewTask(taskModel: TaskModel) {
        addNewTaskRepository.addNewTask(
            taskModel = taskModel,
        )
    }
}