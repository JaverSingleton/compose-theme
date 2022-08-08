package ru.javersingleton.nested_themes.sample3

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import ru.javersingleton.nested_themes.themes.common.component.button.Button
import ru.javersingleton.nested_themes.themes.common.component.button.ButtonStyle

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Sample3Button(
    onClick: () -> Unit,
    title: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isSpinnerEnabled: Boolean = false,
    iconLeft: (@Composable () -> Unit)? = null,
    iconRight: (@Composable () -> Unit)? = null,
    style: ButtonStyle,
) {
    val prefixText = (style as? Sample3ButtonStyle)?.textPrefix.orEmpty()
    Button(
        onClick,
        "$prefixText$title",
        modifier,
        enabled,
        isSpinnerEnabled,
        iconLeft,
        iconRight,
        style
    )
}
interface Sample3ButtonStyle : ButtonStyle {
    val parent: ButtonStyle
    val textPrefix: String?

    fun copy(
        parent: ButtonStyle = this.parent,
        textPrefix: String? = this.textPrefix
    ): Sample3ButtonStyle

}

class DefaultSample3ButtonStyle(
    override val parent: ButtonStyle,
    override val textPrefix: String?
) : Sample3ButtonStyle,
    ButtonStyle by parent {

    override fun copy(
        parent: ButtonStyle,
        textPrefix: String?
    ): Sample3ButtonStyle = DefaultSample3ButtonStyle(
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