package ru.javersingleton.nested_themes.themes.common.button

import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.javersingleton.nested_themes.themes.common.StyleProvider
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.lazyStyle

data class ButtonStyle(
    val backgroundColor: Color,
    val contentColor: Color,
    val pressedColor: Color,
    val disabledBackgroundColor: Color,
    val disabledContentColor: Color,
    val minSize: Dp,
    val textStyle: TextStyle,
    val iconModifier: Modifier,
    val iconPadding: Dp,
    val spinnerModifier: Modifier,
    val horizontalPadding: Dp,
    val spinnerStroke: Dp,
    val elevation: Dp,
    val shape: Shape,
)

fun createButtonPrimaryLarge(): StyleProvider<ButtonStyle> = lazyStyle {
    ButtonStyle(
        backgroundColor = Theme.colors.blue,
        contentColor = Theme.colors.constantWhite,
        pressedColor = Theme.colors.blue600,
        disabledBackgroundColor = Theme.colors.warmGray4,
        disabledContentColor = Theme.colors.gray28,
        minSize = 44.dp,
        textStyle = Theme.typography.m1,
        iconModifier = Modifier.size(22.dp),
        iconPadding = 6.dp,
        spinnerModifier = Modifier.size(22.dp),
        horizontalPadding = 16.dp,
        spinnerStroke = 2.dp,
        elevation = 0.dp,
        shape = Theme.shapes.micro,
    )
}

