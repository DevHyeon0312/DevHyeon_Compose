package com.devhyeon.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.devhyeon.compose.ui.components.BottomNavigation
import com.devhyeon.compose.ui.components.BottomNavigationBar
import com.devhyeon.compose.ui.components.SetDefaultSystemBar
import com.devhyeon.compose.ui.screen.onboarding.OnboardingScreen

class DevHyeonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
            if (shouldShowOnboarding) {
                OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
            } else {
                MainContent()
            }
            SetDefaultSystemBar(window = window)
        }
    }
}

@Composable
fun MainContent() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        BottomNavigation(navController)
    }
}