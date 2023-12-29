package com.example.taskerapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskerapp.presentation.screen.screen_add_category.AddCategoryScreen
import com.example.taskerapp.presentation.screen.screen_add_task.AddTaskScreen
import com.example.taskerapp.presentation.screen.screen_add_task.AddTaskViewModel
import com.example.taskerapp.presentation.screen.screen_main.MainScreen

@Composable
fun TaskerNavigation() {
    val navController = rememberNavController()
    val mainScreenRoute = Screens.MainScreen.route.toString()
    val addTaskScreenRoute = Screens.AddTaskScreen.route.toString()
    val addCategoryScreenRoute = Screens.AddCategoryScreen.route.toString()

    val addTaskViewModel: AddTaskViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = mainScreenRoute,
    ) {
        composable(mainScreenRoute) {
            MainScreen(navController = navController)
        }
        composable(addTaskScreenRoute) {
            AddTaskScreen(
                navController = navController,
                viewModel = addTaskViewModel,
            )
        }
        composable(addCategoryScreenRoute) {
            AddCategoryScreen(navController = navController)
        }
    }
}