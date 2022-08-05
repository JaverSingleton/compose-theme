package ru.javersingleton.nested_themes.themes.redesign

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import ru.javersingleton.nested_themes.themes.common.*
import ru.javersingleton.nested_themes.themes.common.button.ButtonStyle
import ru.javersingleton.nested_themes.themes.common.button.buttonPrimaryLarge
import ru.javersingleton.nested_themes.themes.common.content.ContentStyles
import ru.javersingleton.nested_themes.themes.common.content.contentStyles
import ru.javersingleton.nested_themes.themes.common.promo_block.PromoBlockStyle
import ru.javersingleton.nested_themes.themes.common.promo_block.promoBlock
import ru.javersingleton.nested_themes.themes.redesign.button.redesignButtonPrimary

object RedesignTheme {
    val colors: RedesignColors
        @Composable
        @ReadOnlyComposable
        get() = LocalRedesignColors.current
    val typography: RedesignTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalRedesignTypography.current
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
    buttonPrimaryLarge: StyleProvider<ButtonStyle> = RedesignTheme.redesignButtonPrimary,
    contentStyles: StyleProvider<ContentStyles> = Theme.contentStyles,
    promoBlock: StyleProvider<PromoBlockStyle> = Theme.promoBlock,
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
                blue = colors.blue,
                blue600 = colors.blue600,
                warmGray4 = colors.warmGray4,
                gray28 = colors.gray28
            ),
            typography = Typography(
                m1 = typography.m1
            ),
            shapes = Shapes(
                micro = shapes.micro
            ),
            buttonPrimaryLarge = buttonPrimaryLarge,
            contentStyles = contentStyles,
            promoBlock = promoBlock,
        ) {
            content()
        }
    }
}
