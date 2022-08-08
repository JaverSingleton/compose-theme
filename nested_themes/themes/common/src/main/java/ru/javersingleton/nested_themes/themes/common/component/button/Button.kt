package ru.javersingleton.nested_themes.themes.common.component.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextOverflow


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Button(
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isSpinnerEnabled: Boolean = false,
    style: ButtonStyle,
) {
    val contentCenter: (@Composable () -> Unit) = {
        if (isSpinnerEnabled) {
            CircularProgressIndicator(
                modifier = style.spinnerModifier,
                color = LocalContentColor.current,
                strokeWidth = style.spinnerStroke
            )
        } else {
            icon()
        }
    }
    Button(
        onClick = onClick.takeIf { !isSpinnerEnabled },
        modifier = modifier,
        enabled = enabled,
        contentCenter = contentCenter,
        style = style,
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Button(
    onClick: () -> Unit,
    title: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isSpinnerEnabled: Boolean = false,
    iconLeft: (@Composable () -> Unit)? = null,
    iconRight: (@Composable () -> Unit)? = null,
    style: ButtonStyle
) {
    val contentCenter: (@Composable () -> Unit) = {
        if (isSpinnerEnabled) {
            CircularProgressIndicator(
                modifier = style.spinnerModifier,
                color = LocalContentColor.current,
                strokeWidth = style.spinnerStroke
            )
        } else {
            Text(
                text = title,
                style = LocalTextStyle.current,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
    Button(
        onClick = onClick.takeIf { !isSpinnerEnabled },
        modifier = modifier,
        enabled = enabled,
        contentLeft = iconLeft.takeIf { !isSpinnerEnabled },
        contentRight = iconRight.takeIf { !isSpinnerEnabled },
        contentCenter = contentCenter,
        style = style,
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Button(
    onClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentLeft: (@Composable () -> Unit)? = null,
    contentRight: (@Composable () -> Unit)? = null,
    contentCenter: (@Composable () -> Unit)? = null,
    style: ButtonStyle,
) {
    val colors = ButtonDefaults.buttonColors(
        backgroundColor = style.backgroundColor,
        contentColor = style.contentColor,
        disabledBackgroundColor = style.disabledBackgroundColor,
        disabledContentColor = style.disabledContentColor,
    )
    val contentColor by colors.contentColor(enabled = enabled)

    Surface(
        modifier = modifier,
        shape = style.shape,
        color = colors.backgroundColor(enabled).value,
        contentColor = contentColor.copy(alpha = 1f),
        border = null,
        elevation = style.elevation,
        onClick = onClick ?: {},
        enabled = enabled,
        role = Role.Button,
        interactionSource = remember { MutableInteractionSource() },
        indication = rememberRipple(
            color = if (onClick != null) {
                style.pressedColor
            } else {
                style.backgroundColor
            }
        )
    ) {
        CompositionLocalProvider(
            LocalContentAlpha provides contentColor.alpha
        ) {
            ProvideTextStyle(
                value = style.textStyle
            ) {
                Row(
                    Modifier
                        .defaultMinSize(
                            minWidth = style.minSize,
                            minHeight = style.minSize
                        )
                        .padding(horizontal = style.horizontalPadding),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (contentLeft != null) {
                        val mod = Modifier.padding(end = style.iconPadding)
                        Box(
                            modifier = mod.then(style.iconModifier),
                            contentAlignment = Alignment.Center
                        ) {
                            contentLeft()
                        }
                    }
                    if (contentCenter != null) {
                        contentCenter()
                    }
                    if (contentRight != null) {
                        val mod = Modifier.padding(start = style.iconPadding)
                        Box(
                            modifier = mod.then(style.iconModifier),
                            contentAlignment = Alignment.Center
                        ) {
                            contentRight()
                        }
                    }
                }
            }
        }
    }
}
