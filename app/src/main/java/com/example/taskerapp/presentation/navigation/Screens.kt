package com.example.taskerapp.presentation.navigation

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import com.example.taskerapp.R

@SuppressLint("SupportAnnotationUsage")
sealed class Screens(@StringRes val route:Int) {
    object MainScreen:Screens(R.string.route_main_screen)
    object AddTaskScreen:Screens(R.string.route_add_task_screen)
    object AddCategoryScreen:Screens(R.string.route_add_task_category_screen)
}