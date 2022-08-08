package ru.javersingleton.nested_themes.themes.default

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import ru.javersingleton.nested_themes.themes.common.*

object DefaultTheme {
    val colors: DefaultColors
        @Composable
        @ReadOnlyComposable
        get() = LocalDefaultColors.current
    val typography: DefaultTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalDefaultTypography.current
    val styles: DefaultStyles
        @Composable
        @ReadOnlyComposable
        get() = LocalDefaultStyles.current
    val shapes: DefaultShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalDefaultShapes.current
}

@Composable
fun DefaultTheme(
    colors: DefaultColors = DefaultTheme.colors,
    typography: DefaultTypography = DefaultTheme.typography,
    shapes: DefaultShapes = DefaultTheme.shapes,
    styles: DefaultStyles = DefaultTheme.styles,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalDefaultColors provides remember { colors },
        LocalDefaultShapes provides remember { shapes },
        LocalDefaultTypography provides remember { typography },
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
