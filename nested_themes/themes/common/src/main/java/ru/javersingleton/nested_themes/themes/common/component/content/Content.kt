package ru.javersingleton.nested_themes.themes.common.component.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.javersingleton.nested_themes.themes.common.component.button.Button

@Composable
fun Content(
    modifier: Modifier = Modifier,
    title: String?,
    description: String?,
    primaryButton: Content.Button?,
    secondaryButton: Content.Button?,
    style: ContentStyle = LocalContentStyle.current(),
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
            if (primaryButton != null) {
                Button(
                    onClick = primaryButton.onClick,
                    title = primaryButton.text,
                    style = style.buttonPrimaryStyle()
                )
            }
            if (secondaryButton != null) {
                Button(
                    onClick = secondaryButton.onClick,
                    title = secondaryButton.text,
                    style = style.buttonSecondaryStyle()
                )
            }
        }
    }
}

object Content {
    data class Button(
        val text: String,
        val onClick: () -> Unit
    )
}
