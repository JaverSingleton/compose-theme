package ru.javersingleton.nested_themes.themes.redesign

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import ru.javersingleton.nested_themes.themes.common.*

object RedesignTheme {
    val colors: RedesignColors
        @Composable
        @ReadOnlyComposable
        get() = LocalRedesignColors.current
    val typography: RedesignTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalRedesignTypography.current
    val styles: RedesignStyles
        @Composable
        @ReadOnlyComposable
        get() = LocalRedesignStyles.current
    val shapes: RedesignShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalRedesignShapes.current
}

@Composable
fun RedesignTheme(
    colors: RedesignColors = RedesignTheme.colors,
    typography: RedesignTypography = RedesignTheme.typography,
    shapes: RedesignShapes = RedesignTheme.shapes,
    styles: RedesignStyles = RedesignTheme.styles,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalRedesignColors provides remember { colors },
        LocalRedesignShapes provides remember { shapes },
        LocalRedesignTypography provides remember { typography },
    ) {
        Theme(
            colors = Colors(
                constantWhite = colors.constantWhite,
                constantBlack = colors.constantBlack,
                blue = colors.blue,
                blue600 = colors.blue600,
                warmGray4 = colors.warmGray4,
                gray28 = colors.gray28,
                green50 = colors.green50,
            ),
            typography = Typography(
                m1 = typography.m1,
                h5 = typography.h5,
            ),
            shapes = Shapes(
                micro = shapes.micro
            ),
            styles = Styles(
                contentStyle = styles.contentStyle,
                buttonPrimaryLarge = styles.buttonPrimaryLarge,
                promoBlock = styles.promoBlock
            )
        ) {
            content()
        }
    }
}
