package com.devhyeon.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.devhyeon.compose.ui.screen.home.HomeScreen
import com.devhyeon.compose.ui.screen.onboarding.OnboardingScreen

class DevHyeonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevHyeonContent()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}

@Composable
fun DevHyeonContent() {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    if (shouldShowOnboarding) {
        OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
    } else {
        HomeScreen()
    }
}