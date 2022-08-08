package ru.javersingleton.nested_themes.themes.common

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

data class Typography(
    val m1: TextStyle,
    val h5: TextStyle,
)

internal val LocalTypography: ProvidableCompositionLocal<Typography> =
    staticCompositionLocalOf { throw IllegalStateException() }
