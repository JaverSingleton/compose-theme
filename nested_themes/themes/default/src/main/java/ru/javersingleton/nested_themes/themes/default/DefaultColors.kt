package ru.javersingleton.nested_themes.themes.default

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class DefaultColors(
    val constantWhite: Color = Color(0xFFFFFFFF),
    val constantBlack: Color = Color(0xFF000000),
    val blue: Color = Color(0xFF00AAFF),
    val blue600: Color = Color(0xFF0099F7),
    val warmGray4: Color = Color(0xFFF2F1F0),
    val gray28: Color = Color(0xFFB8B8B8),
    val green50: Color = Color(0xFFEAFCCF),
)

internal val LocalDefaultColors: ProvidableCompositionLocal<DefaultColors> =
    staticCompositionLocalOf { DefaultColors() }
