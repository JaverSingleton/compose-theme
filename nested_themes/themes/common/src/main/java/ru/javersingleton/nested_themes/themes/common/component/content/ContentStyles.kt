package ru.javersingleton.nested_themes.themes.common.component.content

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import ru.javersingleton.nested_themes.themes.common.StyleProvider
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.component.button.ButtonStyle
import ru.javersingleton.nested_themes.themes.common.lazyStyle


interface ContentStyles {
    val buttonPrimaryStyle: StyleProvider<ButtonStyle>
    val buttonSecondaryStyle: StyleProvider<ButtonStyle>
    val titleStyle: TextStyle
    val descriptionStyle: TextStyle

    fun copy(
        buttonPrimaryStyle: StyleProvider<ButtonStyle> = this.buttonPrimaryStyle,
        buttonSecondaryStyle: StyleProvider<ButtonStyle> = this.buttonSecondaryStyle,
        titleStyle: TextStyle = this.titleStyle,
        descriptionStyle: TextStyle = this.descriptionStyle
    ): ContentStyles

}

class DefaultContentStyles(
    override val buttonPrimaryStyle: StyleProvider<ButtonStyle>,
    override val buttonSecondaryStyle: StyleProvider<ButtonStyle>,
    override val titleStyle: TextStyle,
    override val descriptionStyle: TextStyle
) : ContentStyles {

    override fun copy(
        buttonPrimaryStyle: StyleProvider<ButtonStyle>,
        buttonSecondaryStyle: StyleProvider<ButtonStyle>,
        titleStyle: TextStyle,
        descriptionStyle: TextStyle
    ) = DefaultContentStyles(
        buttonPrimaryStyle = buttonPrimaryStyle,
        buttonSecondaryStyle = buttonSecondaryStyle,
        titleStyle = titleStyle,
        descriptionStyle = descriptionStyle
    )

}

val LocalContentStyles: ProvidableCompositionLocal<StyleProvider<ContentStyles>> =
    staticCompositionLocalOf { createContentStyles() }

fun createContentStyles(): StyleProvider<ContentStyles> = lazyStyle {
    DefaultContentStyles(
        buttonPrimaryStyle = Theme.styles.buttonPrimaryLarge,
        buttonSecondaryStyle = Theme.styles.buttonPrimaryLarge,
        titleStyle = Theme.typography.m1,
        descriptionStyle = Theme.typography.m1
    )
}