package com.devhyeon.compose.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.devhyeon.compose.R
import com.devhyeon.compose.ui.screen.home.HomeScreen
import com.devhyeon.compose.ui.theme.navigationBackGroundColor
import com.devhyeon.compose.ui.theme.navigationContentColor

sealed class BottomNavigationItem(var route: String, var iconResId: Int, var title: String) {
    object Home : BottomNavigationItem("home", R.drawable.icon_home, "Home")
    object Chat : BottomNavigationItem("chat", R.drawable.icon_chat, "Chat")
    object More : BottomNavigationItem("more", R.drawable.icon_more, "More")
}

@Composable
fun BottomNavigation(navHostController: NavHostController) {
    NavHost(navHostController, startDestination = BottomNavigationItem.Home.route) {
        composable(BottomNavigationItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavigationItem.Chat.route) {

        }
        composable(BottomNavigationItem.More.route) {

        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Chat,
        BottomNavigationItem.More
    )
    BottomNavigation(
        backgroundColor = navigationBackGroundColor(),
        contentColor = navigationContentColor()
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painter = painterResource(id = item.iconResId), contentDescription = item.title) },
                label = { Text(text = item.title) },
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
