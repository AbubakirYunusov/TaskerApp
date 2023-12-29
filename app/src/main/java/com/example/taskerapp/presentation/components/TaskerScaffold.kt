package com.example.taskerapp.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.taskerapp.R
import com.example.taskerapp.presentation.navigation.Screens
import com.example.taskerapp.presentation.theme.TaskerBlue
import com.example.taskerapp.presentation.theme.dp16
import com.example.taskerapp.presentation.theme.dp18
import com.example.taskerapp.presentation.theme.dp50
import com.example.taskerapp.presentation.theme.sp32

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskerScaffold(
    modifier: Modifier = Modifier,
    titele: String,
    actionIcon: Painter,
    isFloatingValues: Boolean,
    contentCallback: @Composable (PaddingValues) -> Unit,
    navController: NavController,

    ) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = modifier.padding(start = dp50, top = dp16),
                        text = titele,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.Bold,
                        fontSize = sp32,
                        letterSpacing = 0.32.sp,
                    )
                },
                actions = {
                    IconButton(
                        modifier = modifier.padding(top = dp18),
                        onClick = {},
                        content = {
                            Icon(
                                painter = painterResource(id = R.drawable.more),
                                contentDescription = null,
                                tint = TaskerBlue,
                            )
                        },
                    )
                },
            )
        },
        content = { innerPadding ->
            contentCallback.invoke(innerPadding)
        },
        floatingActionButton = {
            if (isFloatingValues) {
                FABComponent(
                ) {
                   navController.navigate(
                       if (it) Screens.AddTaskScreen.route.toString()
                       else Screens.AddCategoryScreen.route.toString()
                   )
                }
            }
        },
    )
}