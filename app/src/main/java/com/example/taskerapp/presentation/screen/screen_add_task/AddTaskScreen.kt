package com.example.taskerapp.presentation.screen.screen_add_task

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.taskerapp.R
import com.example.taskerapp.data.models.CategoryModel
import com.example.taskerapp.presentation.components.CircleColorComponent
import com.example.taskerapp.presentation.components.CustomDatePicker
import com.example.taskerapp.presentation.components.CustomTimePicker
import com.example.taskerapp.presentation.screen.screen_add_task.model.AddTaskBottomMenuActions
import com.example.taskerapp.presentation.theme.EMPTY_STRING
import com.example.taskerapp.presentation.theme.TaskerBlue
import com.example.taskerapp.presentation.theme.dp12
import com.example.taskerapp.presentation.theme.dp16
import com.example.taskerapp.presentation.theme.dp18
import com.example.taskerapp.presentation.theme.dp25
import com.example.taskerapp.presentation.theme.dp6
import com.example.taskerapp.presentation.theme.dp60
import com.example.taskerapp.presentation.theme.dp8
import com.example.taskerapp.presentation.theme.sp18

@Preview
@Composable
fun AddTaskScreenPreview() {
    MaterialTheme {
        AddTaskScreen(navController = rememberNavController(), viewModel = viewModel())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: AddTaskViewModel,
) {
    var bottomMenuClickStata by remember {
        mutableStateOf(AddTaskBottomMenuActions.DEFAULT)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TextButton(
                        onClick = {
                            navController.popBackStack()
                        },
                    ) {
                        Text(
                            text = stringResource(id = R.string.cancel),
                            color = TaskerBlue,
                            fontSize = sp18,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }
                },
                actions = {
                    TextButton(
                        onClick = {
                        },
                    ) {
                        Text(
                            text = stringResource(id = R.string.done),
                            color = TaskerBlue,
                            fontSize = sp18,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding)
        ) {
            TaskTextField()
            Spacer(
                modifier = modifier.weight(1f)
            )
            TaskBottomMenu {
                bottomMenuClickStata = it
            }
            AnimatedVisibility(
                visible = bottomMenuClickStata == AddTaskBottomMenuActions.CHOOSECSTEGORY
            ) {
                CategoryList(
                    categoryList = listOf(
                        CategoryModel(
                            id = 1, "work"
                        ),
                        CategoryModel(
                            id = 2, "work"
                        ),
                        CategoryModel(
                            id = 3, "work"
                        ),
                        CategoryModel(
                            id = 4, "work"
                        ),
                        CategoryModel(
                            id = 5, "work"
                        ),
                    )
                )
            }
            AnimatedVisibility(
                visible = bottomMenuClickStata == AddTaskBottomMenuActions.DATEPCIKER,
            ) {
                CustomDatePicker()
            }
            AnimatedVisibility(
                visible = bottomMenuClickStata == AddTaskBottomMenuActions.TIMEPIKER,
            ) {
                CustomTimePicker()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskTextField(
    modifier: Modifier = Modifier,
) {
    var textFieldStata by remember {
        mutableStateOf(EMPTY_STRING)
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(dp60),
    ) {
        Row(
            modifier = modifier.fillMaxSize()
        ) {
            IconButton(
                onClick = {

                },
            ) {
                Icon(
                    modifier = modifier.padding(start = dp6, top = dp6),
                    painter = painterResource(id = R.drawable.unmarked),
                    contentDescription = null,
                    tint = if (isSystemInDarkTheme()) Color.White
                    else Color.Gray
                )
            }
            TextField(modifier = modifier.fillMaxWidth(), value = textFieldStata, onValueChange = {
                textFieldStata = it
            }, colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.background,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ), placeholder = {
                Text(
                    text = stringResource(id = R.string.text_what_do),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = if (isSystemInDarkTheme()) Color.White
                    else Color.Gray
                )
            })
        }
    }
}

@Composable
fun TaskBottomMenu(
    modifier: Modifier = Modifier,
    onClick: (AddTaskBottomMenuActions) -> Unit,
) {
    Column {
        Divider()
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(dp60)
        ) {
            IconButton(
                modifier = modifier.padding(start = dp8, top = dp18, bottom = dp18),
                onClick = {
                    onClick(AddTaskBottomMenuActions.DATEPCIKER)
                },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.calendar),
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
            IconButton(
                modifier = modifier.padding(start = dp6, top = dp18, bottom = dp18),
                onClick = {
                    onClick(AddTaskBottomMenuActions.TIMEPIKER)
                },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.alarm),
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
            Spacer(modifier = modifier.weight(1f))
            TextButton(onClick = {
                onClick(AddTaskBottomMenuActions.CHOOSECSTEGORY)
            }) {

            }
            Text(
                text = stringResource(id = R.string.text_inbox),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (isSystemInDarkTheme()) Color.White
                else Color.Gray,
                modifier = modifier
                    .padding(
                        top = dp18, end = dp8,
                    )
                    .clickable {
                        onClick(AddTaskBottomMenuActions.CHOOSECSTEGORY)
                    },
            )
            CircleColorComponent(
                modifier = modifier
                    .padding(top = dp25, end = dp16)
                    .size(dp12),
                color = TaskerBlue,
            )
        }
    }
}