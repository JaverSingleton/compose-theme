package ru.javersingleton.nested_themes.themes.redesign.button

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.javersingleton.nested_themes.themes.common.button.Button
import ru.javersingleton.nested_themes.themes.common.button.ButtonStyle

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RedesignButton(
    onClick: () -> Unit,
    title: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isSpinnerEnabled: Boolean = false,
    iconLeft: (@Composable () -> Unit)? = null,
    iconRight: (@Composable () -> Unit)? = null,
    style: ButtonStyle,
) {
    val prefixText = (style as? RedesignButtonStyle)?.textPrefix.orEmpty()
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