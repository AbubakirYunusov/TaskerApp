package com.example.taskerapp.presentation.screen.screen_add_task

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.taskerapp.R
import com.example.taskerapp.damain.use_cases.AddNewTaskUseCaseImpl
import com.example.taskerapp.damain.use_cases.GetAllTaskUseCaseImpl
import com.example.taskerapp.data.models.TaskModel
import com.example.taskerapp.data.repository_impl.TaskRepositoryImpl
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import java.util.UUID

class AddTaskViewModel : ViewModel() {

    private val taskRepository = TaskRepositoryImpl()
    private val addNawTaskUseCase = AddNewTaskUseCaseImpl(taskRepository)
    private val getAllTaskImpl = GetAllTaskUseCaseImpl(taskRepository)

    private val _toastFlow = MutableSharedFlow<Int>(1)
    val toastFlow = _toastFlow.asSharedFlow()

    var uiState by mutableStateOf(AddTaskUiState())

    fun addNewtask() {
        if (uiState.taskText.isNullOrBlank()) {
            _toastFlow.tryEmit(R.string.not_filled_text_field)
        }
        if (uiState.taskDate.isNullOrBlank()) {
            _toastFlow.tryEmit(R.string.not_filled_date)
        }
        if (uiState.taskTime.isNullOrBlank()) {
            _toastFlow.tryEmit(R.string.not_filled_time)
        }
        if (uiState.taskCategory == null) {
            _toastFlow.tryEmit(R.string.not_selected_category)
        }
        val task = TaskModel(
            taskId = UUID.randomUUID().toString(),
            taskText = uiState.taskText!!,
            taskData = uiState.taskDate!!,
            taskTime = uiState.taskTime!!,
            categoryId = uiState.taskCategory?.id!!,
        )
        addNawTaskUseCase.addNewTask(task)
    }
}