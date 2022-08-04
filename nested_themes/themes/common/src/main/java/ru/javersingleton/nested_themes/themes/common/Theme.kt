package ru.javersingleton.nested_themes.themes.common

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import ru.javersingleton.nested_themes.themes.common.button.ButtonStyle
import ru.javersingleton.nested_themes.themes.common.button.LocalButtonPrimaryLarge
import ru.javersingleton.nested_themes.themes.common.button.buttonPrimaryLarge
import ru.javersingleton.nested_themes.themes.common.content.ContentStyles
import ru.javersingleton.nested_themes.themes.common.content.LocalContentStyles
import ru.javersingleton.nested_themes.themes.common.content.contentDefault
import ru.javersingleton.nested_themes.themes.common.promo_block.LocalPromoBlockDefault
import ru.javersingleton.nested_themes.themes.common.promo_block.PromoBlockStyle
import ru.javersingleton.nested_themes.themes.common.promo_block.promoBlockDefault

// 1. При создании нового компонента разработчик должен иметь возможность использовать для стиля токены
// 2. После внесения компонента в токены разработчик должен иметь возможность изменить стиль на своём уровне

object Theme {
    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current
}

@Composable
fun Theme(
    colors: Colors = Theme.colors,
    typography: Typography = Theme.typography,
    shapes: Shapes = Theme.shapes,
    contentDefault: @Composable () -> ContentStyles = { Theme.contentDefault() },
    buttonPrimaryLarge: @Composable () -> ButtonStyle = { Theme.buttonPrimaryLarge() },
    promoBlockDefault: @Composable () -> PromoBlockStyle = { Theme.promoBlockDefault() },
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides remember { colors },
        LocalTypography provides remember { typography },
        LocalShapes provides remember { shapes },
    ) {
        val buttonPrimaryLarge = buttonPrimaryLarge()
        val promoBlockDefault = promoBlockDefault()
        CompositionLocalProvider(
            LocalButtonPrimaryLarge provides remember { buttonPrimaryLarge },
            LocalPromoBlockDefault provides remember { promoBlockDefault }
        ) {
            val contentDefault = contentDefault()
            CompositionLocalProvider(
                LocalContentStyles provides remember { contentDefault },
            ) {
                MaterialTheme {
                    content()
                }
            }
        }
    }
}

