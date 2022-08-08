package ru.javersingleton.nested_themes.themes.common.content

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import ru.javersingleton.nested_themes.themes.common.StyleProvider
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.button.ButtonStyle
import ru.javersingleton.nested_themes.themes.common.lazyStyle


data class ContentStyles(
    val buttonPrimaryStyle: StyleProvider<ButtonStyle>,
    val buttonSecondaryStyle: StyleProvider<ButtonStyle>,
    val titleStyle: TextStyle,
    val descriptionStyle: TextStyle,
)

val LocalContentStyles: ProvidableCompositionLocal<StyleProvider<ContentStyles>> =
    staticCompositionLocalOf { createContentStyles() }

fun createContentStyles(): StyleProvider<ContentStyles> = lazyStyle {
    ContentStyles(
        buttonPrimaryStyle = Theme.styles.buttonPrimaryLarge,
        buttonSecondaryStyle = Theme.styles.buttonPrimaryLarge,
        titleStyle = Theme.typography.m1,
        descriptionStyle = Theme.typography.m1
    )
}