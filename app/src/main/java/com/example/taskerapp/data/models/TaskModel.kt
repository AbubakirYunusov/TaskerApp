package com.example.taskerapp.data.models

import androidx.compose.runtime.Immutable

@Immutable
data class TaskModel(
    val taskId: String,
    val taskText: String,
    val taskData: String,
    val taskTime: String,
    val categoryId: Int,
)

@Immutable
data class CategoryModel (
    val id: Int,
    val categoryTitle: String,
//    val tasks: ImmutableList<CategoryModel>,
)