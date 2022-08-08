package ru.javersingleton.nested_themes.themes.common.component.promo_block

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.component.content.Content
import ru.javersingleton.nested_themes.themes.common.component.content.ContentStyle
import ru.javersingleton.nested_themes.themes.common.component.content.LocalContentStyle

@Composable
fun PromoBlock(
    modifier: Modifier = Modifier,
    style: PromoBlockStyle = Theme.styles.promoBlock(),
    title: String? = null,
    description: String? = null,
    buttonsPanel: (@Composable RowScope.(contentStyle: ContentStyle) -> Unit)? = null,
) {
    PromoBlock(
        modifier = modifier,
        style = style,
        content = {
            Content(
                title = title,
                description = description,
                buttonsPanel = buttonsPanel,
                style = it,
            )
        }
    )
}

@Composable
fun PromoBlock(
    modifier: Modifier = Modifier,
    style: PromoBlockStyle = Theme.styles.promoBlock(),
    content: @Composable (contentStyle: ContentStyle) -> Unit
) {
    Surface(
        shape = style.shape,
        modifier = modifier,
        color = style.color,
        contentColor = style.contentColor,
    ) {
        Row {
            Column(
                modifier = Modifier.padding(style.padding),
            ) {
                CompositionLocalProvider(
                    LocalContentStyle provides remember { style.contentStyle },
                ) {
                    content(LocalContentStyle.current())
                }
            }
        }
    }
}


