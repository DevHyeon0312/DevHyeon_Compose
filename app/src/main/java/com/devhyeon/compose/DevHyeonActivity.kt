package com.devhyeon.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devhyeon.compose.ui.components.SetTransDebugSystemBar
import com.devhyeon.compose.ui.components.SetTransSystemBar
import com.devhyeon.compose.ui.screen.home.HomeScreen
import com.devhyeon.compose.ui.screen.onboarding.OnboardingScreen

class DevHyeonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevHyeonContent()
            if (BuildConfig.DEBUG) {
                SetTransDebugSystemBar(window = window)
            } else {
                SetTransSystemBar(window = window)
            }
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