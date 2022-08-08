package ru.javersingleton.nested_themes.themes.redesign.button

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import ru.javersingleton.nested_themes.themes.common.StyleProvider
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.button.Button
import ru.javersingleton.nested_themes.themes.common.button.ButtonStyle
import ru.javersingleton.nested_themes.themes.common.lazyStyle
import ru.javersingleton.nested_themes.themes.redesign.RedesignTheme

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
    Button(
        onClick,
        "Redesign $title",
        modifier,
        enabled,
        isSpinnerEnabled,
        iconLeft,
        iconRight,
        style
    )
}

val RedesignTheme.redesignButtonPrimary: StyleProvider<ButtonStyle>
    @Composable
    @ReadOnlyComposable
    get() = lazyStyle(parent = Theme.styles.buttonPrimaryLarge) {
        copy(
            backgroundColor = colors.redesignRed
        )
    }