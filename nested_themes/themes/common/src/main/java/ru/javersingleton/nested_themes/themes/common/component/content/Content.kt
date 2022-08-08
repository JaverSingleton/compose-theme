package ru.javersingleton.nested_themes.themes.common.component.content

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Content(
    modifier: Modifier = Modifier,
    title: String?,
    description: String?,
    style: ContentStyle = LocalContentStyle.current(),
    buttonsPanel: (@Composable RowScope.(contentStyle: ContentStyle) -> Unit)? = null,
) {
    Column(
        modifier,
        verticalArrangement = Arrangement.spacedBy(style.contentSpacing)
    ) {
        if (title != null) {
            Text(
                text = title,
                style = style.titleStyle
            )
        }
        if (description != null) {
            Text(
                text = description,
                style = style.descriptionStyle
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(style.buttonSpacing)
        ) {
            buttonsPanel?.invoke(this, style)
        }
    }
}
