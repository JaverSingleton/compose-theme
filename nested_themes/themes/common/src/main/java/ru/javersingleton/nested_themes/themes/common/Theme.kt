package ru.javersingleton.nested_themes.themes.common

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import ru.javersingleton.nested_themes.themes.common.content.LocalContentStyles

// 1. При создании нового компонента разработчик должен иметь возможность использовать для стиля токены
// 2. После внесения компонента в токены разработчик должен иметь возможность изменить стиль на своём уровне
// 3. Есть CommonTheme используя которую будет работать во всех темах

object Theme {
    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
    val styles: Styles
        @Composable
        @ReadOnlyComposable
        get() = LocalStyles.current
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
    styles: Styles = Theme.styles,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides remember { colors },
        LocalTypography provides remember { typography },
        LocalShapes provides remember { shapes },
    ) {
        CompositionLocalProvider(
            LocalStyles provides remember { styles },
            LocalContentStyles provides remember { styles.contentStyles },
        ) {
            MaterialTheme {
                content()
            }
        }
    }
}

