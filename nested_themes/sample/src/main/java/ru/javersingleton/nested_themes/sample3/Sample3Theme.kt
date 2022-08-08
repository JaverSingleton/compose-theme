package ru.javersingleton.nested_themes.sample3

import androidx.compose.runtime.Composable
import ru.javersingleton.nested_themes.themes.common.lazyStyle
import ru.javersingleton.nested_themes.themes.default.DefaultTheme


@Composable
fun Sample3Theme(
    content: @Composable () -> Unit
) {
    DefaultTheme(
        styles = DefaultTheme.styles.copy(
            buttonPrimaryLarge = lazyStyle(DefaultTheme.styles.buttonPrimaryLarge) {
                DefaultSample3ButtonStyle(
                    this,
                    "Модифицированный "
                )
            }
        ),
        content = content
    )
}