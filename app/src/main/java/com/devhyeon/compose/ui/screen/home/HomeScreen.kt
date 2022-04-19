package com.devhyeon.compose.ui.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devhyeon.compose.ui.components.HomeListItemView
import com.devhyeon.compose.ui.theme.DevHyeonCompose1Theme

@Composable
fun HomeScreen() {
    println("DevHyeon >>>> HomeScreen()")
    DevHyeonCompose1Theme {
        Surface(color = MaterialTheme.colors.background) {
            val items: List<String> = List(100) { "$it" }
            LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
                items(items = items) { number ->
                    HomeListItemView(
                        title = "Hello,",
                        subTitle = number,
                        message = "Compose Study My nickname is DevHyeon",
                        defaultExpanded = false
                    )
                }
            }
        }
    }
}