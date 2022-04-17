package com.devhyeon.compose.ui.components

import android.view.Window
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * [https://github.com/google/accompanist/tree/main/systemuicontroller]
 *
 * build.gradle(Module Level)
 *
 * dependencies {
 *
 *      implementation "com.google.accompanist:accompanist-systemuicontroller:{version}"
 *
 * }
 * */

@Composable
fun SetTransDebugSystemBar(window: Window) {
    SetSystemBar(
        window = window,
        decorFitsSystemWindows = false,
        darkColor = Color.Transparent,
        lightColor = Color.Transparent
    )
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "BuildType : Debug",
        textAlign = TextAlign.Center,
        color = Color.Red
    )
}

@Composable
fun SetTransSystemBar(window: Window) {
    SetSystemBar(
        window = window,
        decorFitsSystemWindows = false,
        darkColor = Color.Transparent,
        lightColor = Color.Transparent
    )
}

@Composable
fun SetDefaultSystemBar(window: Window) {
    SetSystemBar(
        window = window,
        decorFitsSystemWindows = true,
        darkColor = Color.Black,
        lightColor = Color.White
    )
}

@Composable
private fun SetSystemBar(window: Window, decorFitsSystemWindows: Boolean, darkColor: Color, lightColor: Color) {
    WindowCompat.setDecorFitsSystemWindows(window, decorFitsSystemWindows)
    val systemUiController = rememberSystemUiController()
    if (isSystemInDarkTheme()) {
        systemUiController.setSystemBarsColor(
            color = darkColor,
            darkIcons = false
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = lightColor,
            darkIcons = true
        )
    }
}