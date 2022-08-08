package ru.javersingleton.nested_themes.themes.redesign.button

import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.javersingleton.nested_themes.themes.common.StyleProvider
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.component.button.ButtonStyle
import ru.javersingleton.nested_themes.themes.common.component.button.DefaultButtonStyle
import ru.javersingleton.nested_themes.themes.common.lazyStyle

interface RedesignButtonStyle : ButtonStyle {
    val parent: ButtonStyle
    val textPrefix: String?

    fun copy(
        parent: ButtonStyle = this.parent,
        textPrefix: String? = this.textPrefix
    ): RedesignButtonStyle

}

class DefaultRedesignButtonStyle(
    override val parent: ButtonStyle,
    override val textPrefix: String?
) : RedesignButtonStyle,
    ButtonStyle by parent {

    override fun copy(
        parent: ButtonStyle,
        textPrefix: String?
    ): RedesignButtonStyle = DefaultRedesignButtonStyle(
        parent = parent,
        textPrefix = textPrefix
    )

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
    ): ButtonStyle = copy(
        parent = parent.copy(
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
    )

}


fun createRedesignButtonPrimaryLarge(): StyleProvider<RedesignButtonStyle> = lazyStyle {
    DefaultRedesignButtonStyle(
        parent = DefaultButtonStyle(
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
        ),
        textPrefix = "Redesign ",
    )
}