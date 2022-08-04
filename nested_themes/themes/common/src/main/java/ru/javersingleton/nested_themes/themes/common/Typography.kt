package ru.javersingleton.nested_themes.themes.common

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

data class Typography(
    val m1: TextStyle,
)

internal val LocalTypography: ProvidableCompositionLocal<Typography> =
    staticCompositionLocalOf { throw IllegalStateException() }
