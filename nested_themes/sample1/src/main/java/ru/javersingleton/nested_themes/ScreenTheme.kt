package ru.javersingleton.nested_themes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import ru.javersingleton.nested_themes.themes.common.lazyStyle
import ru.javersingleton.nested_themes.themes.redesign.*

object ScreenTheme {
    val colors: RedesignColors
        @Composable
        @ReadOnlyComposable
        get() = RedesignTheme.colors
    val typography: RedesignTypography
        @Composable
        @ReadOnlyComposable
        get() = RedesignTheme.typography
    val styles: RedesignStyles
        @Composable
        @ReadOnlyComposable
        get() = RedesignTheme.styles
    val shapes: RedesignShapes
        @Composable
        @ReadOnlyComposable
        get() = RedesignTheme.shapes
}

@Composable
fun ScreenTheme(
    content: @Composable () -> Unit
) {
    RedesignTheme(
        styles = RedesignTheme.styles.copy(
            buttonPrimaryLarge = lazyStyle(RedesignTheme.styles.buttonPrimaryLarge) {
                copy(
                    textPrefix = "Screen $textPrefix"
                )
            }
        )
    ) {
        content()
    }
}
