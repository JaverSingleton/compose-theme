package ru.javersingleton.nested_themes.themes.common.content

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.button.ButtonStyle
import ru.javersingleton.nested_themes.themes.common.button.buttonPrimaryLarge


data class ContentStyles(
    val buttonPrimaryStyle: ButtonStyle,
    val buttonSecondaryStyle: ButtonStyle,
    val titleStyle: TextStyle,
    val descriptionStyle: TextStyle,
)

@Composable
fun Theme.contentDefault() = ContentStyles(
    buttonPrimaryStyle = buttonPrimaryLarge,
    buttonSecondaryStyle = buttonPrimaryLarge,
    titleStyle = typography.m1,
    descriptionStyle = typography.m1
)

val LocalContentStyles: ProvidableCompositionLocal<ContentStyles> =
    staticCompositionLocalOf { throw IllegalStateException() }

val Theme.contentStyles: ContentStyles
    @Composable
    @ReadOnlyComposable
    get() = LocalContentStyles.current