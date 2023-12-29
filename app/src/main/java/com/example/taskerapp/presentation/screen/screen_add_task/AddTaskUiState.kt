package com.example.taskerapp.presentation.screen.screen_add_task

import com.example.taskerapp.data.models.CategoryModel

data class AddTaskUiState(
    var taskText: String? = String(),
    var taskDate: String? = String(),
    var taskTime: String? = String(),
    var taskCategory: CategoryModel? = null,
    var taskCategoryList: List<CategoryModel>? = emptyList(),
)