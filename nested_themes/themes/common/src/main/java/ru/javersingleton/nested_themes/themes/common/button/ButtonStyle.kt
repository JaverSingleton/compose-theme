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

interface ButtonStyle {
    val backgroundColor: Color
    val contentColor: Color
    val pressedColor: Color
    val disabledBackgroundColor: Color
    val disabledContentColor: Color
    val minSize: Dp
    val textStyle: TextStyle
    val iconModifier: Modifier
    val iconPadding: Dp
    val spinnerModifier: Modifier
    val horizontalPadding: Dp
    val spinnerStroke: Dp
    val elevation: Dp
    val shape: Shape

    fun copy(
        backgroundColor: Color = this.backgroundColor,
        contentColor: Color = this.contentColor,
        pressedColor: Color = this.pressedColor,
        disabledBackgroundColor: Color = this.disabledBackgroundColor,
        disabledContentColor: Color = this.disabledContentColor,
        minSize: Dp = this.minSize,
        textStyle: TextStyle = this.textStyle,
        iconModifier: Modifier = this.iconModifier,
        iconPadding: Dp = this.iconPadding,
        spinnerModifier: Modifier = this.spinnerModifier,
        horizontalPadding: Dp = this.horizontalPadding,
        spinnerStroke: Dp = this.spinnerStroke,
        elevation: Dp = this.elevation,
        shape: Shape = this.shape,
    ): ButtonStyle
}

class DefaultButtonStyle(
    override val backgroundColor: Color,
    override val contentColor: Color,
    override val pressedColor: Color,
    override val disabledBackgroundColor: Color,
    override val disabledContentColor: Color,
    override val minSize: Dp,
    override val textStyle: TextStyle,
    override val iconModifier: Modifier,
    override val iconPadding: Dp,
    override val spinnerModifier: Modifier,
    override val horizontalPadding: Dp,
    override val spinnerStroke: Dp,
    override val elevation: Dp,
    override val shape: Shape
) : ButtonStyle {

    override fun copy(
        backgroundColor: Color,
        contentColor: Color,
        pressedColor: Color,
        disabledBackgroundColor: Color,
        disabledContentColor: Color,
        minSize: Dp,
        textStyle: TextStyle,
        iconModifier: Modifier,
        iconPadding: Dp,
        spinnerModifier: Modifier,
        horizontalPadding: Dp,
        spinnerStroke: Dp,
        elevation: Dp,
        shape: Shape
    ) = DefaultButtonStyle(
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        pressedColor = pressedColor,
        disabledBackgroundColor = disabledBackgroundColor,
        disabledContentColor = disabledContentColor,
        minSize = minSize,
        textStyle = textStyle,
        iconModifier = iconModifier,
        iconPadding = iconPadding,
        spinnerModifier = spinnerModifier,
        horizontalPadding = horizontalPadding,
        spinnerStroke = spinnerStroke,
        elevation = elevation,
        shape = shape,
    )

}

fun createButtonPrimaryLarge(): StyleProvider<ButtonStyle> = lazyStyle {
    DefaultButtonStyle(
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

