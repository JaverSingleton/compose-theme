package ru.javersingleton.nested_themes.themes.default

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight as ComposeFontWeight

data class DefaultTypography(
    val m1: TextStyle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight.Regular,
    ),
    val h5: TextStyle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Heavy,
    )
)

object FontWeight {
    @Stable
    val Regular = ComposeFontWeight.W400

    @Stable
    val Heavy = ComposeFontWeight.W700
}

internal val LocalDefaultTypography: ProvidableCompositionLocal<DefaultTypography> =
    staticCompositionLocalOf { DefaultTypography() }
