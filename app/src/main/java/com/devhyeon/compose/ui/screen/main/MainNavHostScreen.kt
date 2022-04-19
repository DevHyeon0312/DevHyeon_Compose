package com.devhyeon.compose.ui.screen.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.devhyeon.compose.R
import com.devhyeon.compose.ui.screen.home.HomeScreen
import com.devhyeon.compose.ui.theme.navigationBackGroundColor
import com.devhyeon.compose.ui.theme.navigationContentColor

@Composable
fun MainNavHostScreen() {
    val allScreens = MainNav.values()
    var currentScreen by rememberSaveable { mutableStateOf(MainNav.HomeView) }
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = navigationBackGroundColor(),
                contentColor = navigationContentColor()
            ) {
                allScreens.forEach {
                    BottomNavigationItem(
                        icon = { Icon(painter = painterResource(id = it.imageResId), contentDescription = it.imageDescription) },
                        label = { Text(text = it.text) },
                        selected = it == currentScreen,
                        onClick = {
                            currentScreen = it
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            currentScreen.Content(
                onScreenChange = { screen ->
                    currentScreen = MainNav.valueOf(screen)
                }
            )
        }
    }
}

enum class MainNav(
    val imageResId: Int,
    val imageDescription: String,
    val text: String,
    val body: @Composable ((String) -> Unit) -> Unit
) {
    HomeView(
        imageResId = R.drawable.icon_home,
        imageDescription = "HomeIcon",
        text = "Home",
        body = { HomeScreen() }
    ),
    ChatView(
        imageResId = R.drawable.icon_chat,
        imageDescription = "ChatIcon",
        text = "Chat",
        body = {  }
    ),
    MoreView(
        imageResId = R.drawable.icon_more,
        imageDescription = "MoreIcon",
        text = "More",
        body = {  }
    );

    @Composable
    fun Content(onScreenChange: (String) -> Unit) {
        body(onScreenChange)
    }
}
