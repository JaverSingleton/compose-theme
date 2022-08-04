package ru.javersingleton.nested_themes.themes.common

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class Colors(
    val constantWhite: Color,
    val blue: Color,
    val blue600: Color,
    val warmGray4: Color,
    val gray28: Color,
)

internal val LocalColors: ProvidableCompositionLocal<Colors> =
    staticCompositionLocalOf { throw IllegalStateException() }
