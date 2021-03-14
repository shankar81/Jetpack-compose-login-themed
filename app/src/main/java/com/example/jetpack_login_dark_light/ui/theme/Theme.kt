package com.example.jetpack_login_dark_light.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Purple500,
    primaryVariant = Purple200,
    secondary = Teal200,
    background = Black,
    onPrimary = White,
    onBackground = Gray,
    onSurface = Gray,
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple200,
    secondary = Teal200,
    background = White,
    onPrimary = White,
    onBackground = Gray,
    onSurface = Black,

    /* Other default colors to override
    surface = Color.White,
    onSecondary = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun JetpacklogindarklightTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}