package ru.javersingleton.nested_themes.themes.redesign

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

data class RedesignShapes(
    val micro: CornerBasedShape = RoundedCornerShape(6.dp),
)

internal val LocalRedesignShapes: ProvidableCompositionLocal<RedesignShapes> =
    staticCompositionLocalOf { RedesignShapes() }
