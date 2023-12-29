package com.example.taskerapp.presentation.screen.screen_add_task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.taskerapp.data.models.CategoryModel
import com.example.taskerapp.presentation.theme.TaskerBlue
import com.example.taskerapp.presentation.theme.dp12
import com.example.taskerapp.presentation.theme.dp14
import com.example.taskerapp.presentation.theme.dp16
import com.example.taskerapp.presentation.theme.dp90

@Preview
@Composable
fun CategoryListPreview() {
    CategoryList(
        categoryList = listOf(
            CategoryModel(
                id = 1, "Work"
            )
        )
    )
}

@Composable
fun CategoryList(
    modifier: Modifier = Modifier,
    categoryList: List<CategoryModel>,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = categoryList,
            key = { item -> item.id }
        ) { item ->
            CategoryItem(
                categoryModel = item,
            )
        }
    }
}

@Composable
fun CategoryItem(
    categoryModel: CategoryModel,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(dp90)
            .padding(start = dp16, end = dp16, top = dp12),
        shape = RoundedCornerShape(dp12),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(TaskerBlue)
        ) {
            Text(
                modifier = Modifier.padding(
                    top = dp14,
                    start = dp14,
                ),
                text = categoryModel.categoryTitle,
                fontSize = 19.sp,
                lineHeight = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
            )
        }
    }
}