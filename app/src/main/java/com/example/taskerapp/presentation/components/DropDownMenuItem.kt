package com.example.taskerapp.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import com.example.taskerapp.R
import com.example.taskerapp.presentation.theme.TaskerBlue
import com.example.taskerapp.presentation.theme.dp12
import com.example.taskerapp.presentation.theme.dp14
import com.example.taskerapp.presentation.theme.dp200

@Preview
@Composable
fun DropDownMenuItemPreview() {
    MaterialTheme {
        DropDownMenu(
            onDismissMenu = {}
        ) {
        }
    }
}

@Composable
fun DropDownMenu(
    modifier: Modifier = Modifier,
    onDismissMenu: () -> Unit,
    onClickCallBack: (isTask: Boolean) -> Unit,
) {
    DropdownMenu(
        modifier = modifier
            .width(dp200)
            .background(MaterialTheme.colorScheme.background)
            .clip(RoundedCornerShape(dp14)),
        expanded = true,
        offset = DpOffset(dp12, dp12),
        onDismissRequest = {
            onDismissMenu.invoke()
        },
    ) {
        DropdownMenuItem(
            isTask = true,
            title = R.string.task,
            icon = R.drawable.icon_task,
            onClickCallBack = {
                onClickCallBack.invoke(it)
            }
        )
        Divider()
        DropdownMenuItem(
            isTask = false,
            title = R.string.list,
            icon = R.drawable.icon_list,
            onClickCallBack = {
                onClickCallBack.invoke(it)
            }
        )
    }
}

@Composable
fun DropdownMenuItem(
    @StringRes title: Int,
    @DrawableRes icon: Int,
    onClickCallBack: (isTask: Boolean) -> Unit,
    isTask: Boolean
) {
    DropdownMenuItem(
        text = {
            Text(
                text = stringResource(id = title),
                color = TaskerBlue,
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = TaskerBlue,
            )
        },
        onClick = {
            onClickCallBack.invoke(isTask)
        },
    )
}