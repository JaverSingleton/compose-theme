package ru.javersingleton.nested_themes.themes.default

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

data class DefaultShapes(
    val micro: CornerBasedShape = RoundedCornerShape(6.dp),
)

internal val LocalDefaultShapes: ProvidableCompositionLocal<DefaultShapes> =
    staticCompositionLocalOf { DefaultShapes() }
