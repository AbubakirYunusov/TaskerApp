package com.example.taskerapp.data.repository_impl

import com.example.taskerapp.damain.repository.TaskRepository
import com.example.taskerapp.data.mapprs.toCache
import com.example.taskerapp.data.mapprs.toDataModel
import com.example.taskerapp.data.models.TaskModel
import com.example.taskerapp.presentation.App

class TaskRepositoryImpl : TaskRepository {

    val dao = App.database.getTaskDao()

    override fun addNewTask(taskModel: TaskModel) {
        dao.addNewTask(
            taskModelCache = taskModel.toCache()
        )
    }

    override fun getAllTasks(): List<TaskModel> {
       return dao.getAllTasks().map {
           it.toDataModel()
       }
    }
}