package ru.javersingleton.nested_themes.themes.common

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf

data class Shapes(
    val micro: CornerBasedShape,
)

internal val LocalShapes: ProvidableCompositionLocal<Shapes> =
    staticCompositionLocalOf { throw IllegalStateException() }
