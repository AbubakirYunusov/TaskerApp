package com.example.taskerapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskerapp.R
import com.example.taskerapp.presentation.theme.TaskerBlue

@Preview
@Composable
fun CustomDatePickerPreview() {
    CustomDatePicker()

}

@Composable
fun CustomDatePicker(
    modifier: Modifier = Modifier,
) {
    Column {
        Spacer(modifier = modifier.height(30.dp))

        DatePickerUtil(height = 200.dp)

        Spacer(modifier = modifier.height(20.dp))

        Button(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp),
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = TaskerBlue,
            ),
        ) {
            Text(
                text = stringResource(id = R.string.text_confirm),
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onBackground,

                )
        }
    }
}

@Composable
fun DatePickerUtil(
    modifier: Modifier = Modifier,
    height: Dp,
) {

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .height(height),
    ) {
        InfiniteItemsPicker(
            items = days,
            firstIndex = 0,
            onItemSelected = {},
            textStyle = MaterialTheme.typography.titleLarge.copy(
                fontSize = 26.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onBackground,
            ),
        )
        InfiniteItemsPicker(
            items = monthsNames,
            firstIndex = 0,
            onItemSelected = {},
            textStyle = MaterialTheme.typography.titleLarge.copy(
                fontSize = 26.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onBackground,
            ),
        )
        InfiniteItemsPicker(
            items = years,
            firstIndex = 0,
            onItemSelected = {},
            textStyle = MaterialTheme.typography.titleLarge.copy(
                fontSize = 26.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onBackground,
            ),
        )
    }
}