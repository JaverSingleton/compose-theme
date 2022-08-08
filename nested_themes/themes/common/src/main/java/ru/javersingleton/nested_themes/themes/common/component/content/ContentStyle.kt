package ru.javersingleton.nested_themes.themes.common.component.content

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.javersingleton.nested_themes.themes.common.StyleProvider
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.component.button.ButtonStyle
import ru.javersingleton.nested_themes.themes.common.lazyStyle


interface ContentStyle {
    val buttonPrimaryStyle: StyleProvider<ButtonStyle>
    val buttonSecondaryStyle: StyleProvider<ButtonStyle>
    val titleStyle: TextStyle
    val descriptionStyle: TextStyle
    val contentSpacing: Dp
    val buttonSpacing: Dp

    fun copy(
        buttonPrimaryStyle: StyleProvider<ButtonStyle> = this.buttonPrimaryStyle,
        buttonSecondaryStyle: StyleProvider<ButtonStyle> = this.buttonSecondaryStyle,
        titleStyle: TextStyle = this.titleStyle,
        descriptionStyle: TextStyle = this.descriptionStyle,
        contentSpacing: Dp = this.contentSpacing,
        buttonSpacing: Dp = this.buttonSpacing
    ): ContentStyle

}

class DefaultContentStyle(
    override val buttonPrimaryStyle: StyleProvider<ButtonStyle>,
    override val buttonSecondaryStyle: StyleProvider<ButtonStyle>,
    override val titleStyle: TextStyle,
    override val descriptionStyle: TextStyle,
    override val contentSpacing: Dp,
    override val buttonSpacing: Dp,
) : ContentStyle {

    override fun copy(
        buttonPrimaryStyle: StyleProvider<ButtonStyle>,
        buttonSecondaryStyle: StyleProvider<ButtonStyle>,
        titleStyle: TextStyle,
        descriptionStyle: TextStyle,
        contentSpacing: Dp,
        buttonSpacing: Dp,
    ) = DefaultContentStyle(
        buttonPrimaryStyle = buttonPrimaryStyle,
        buttonSecondaryStyle = buttonSecondaryStyle,
        titleStyle = titleStyle,
        descriptionStyle = descriptionStyle,
        contentSpacing = contentSpacing,
        buttonSpacing = buttonSpacing,
    )

}

val LocalContentStyle: ProvidableCompositionLocal<StyleProvider<ContentStyle>> =
    staticCompositionLocalOf { createContentStyle() }

fun createContentStyle(): StyleProvider<ContentStyle> = lazyStyle {
    DefaultContentStyle(
        buttonPrimaryStyle = Theme.styles.buttonPrimaryLarge,
        buttonSecondaryStyle = Theme.styles.buttonPrimaryLarge,
        titleStyle = Theme.typography.m1,
        descriptionStyle = Theme.typography.m1,
        contentSpacing = 2.dp,
        buttonSpacing = 6.dp,
    )
}