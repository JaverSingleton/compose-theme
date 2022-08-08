package ru.javersingleton.nested_themes.sample3

import androidx.compose.runtime.Composable
import ru.javersingleton.nested_themes.themes.common.lazyStyle
import ru.javersingleton.nested_themes.themes.redesign.RedesignTheme


@Composable
fun Sample3Theme(
    content: @Composable () -> Unit
) {
    RedesignTheme(
        styles = RedesignTheme.styles.copy(
            buttonPrimaryLarge = lazyStyle(RedesignTheme.styles.buttonPrimaryLarge) {
                DefaultSample3ButtonStyle(
                    this,
                    "Модифицированный "
                )
            }
        ),
        content = content
    )
}