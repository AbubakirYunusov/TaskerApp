package com.example.taskerapp.presentation.screen.screen_main

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.taskerapp.R
import com.example.taskerapp.presentation.components.TaskerScaffold

@Preview
@Composable
fun MainScreenPreview() {
    MaterialTheme{
        MainScreen(navController = rememberNavController())
    }

}

@Composable
fun MainScreen(
    modifire: Modifier = Modifier,
    navController: NavController,
) {
    TaskerScaffold(
        titele = stringResource(id = R.string.today),
        actionIcon = painterResource(id = R.drawable.more),
        isFloatingValues = true,
        navController = navController,
        contentCallback = { innerPadding ->

        }
    )
}