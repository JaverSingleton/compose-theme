package ru.javersingleton.nested_themes.sample1

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ru.javersingleton.nested_themes.themes.redesign.RedesignTheme


@Composable
fun Sample1Theme(
    content: @Composable () -> Unit
) {
    RedesignTheme(
        colors = RedesignTheme.colors.copy(
            blue = Color.Red
        ),
        content = content
    )
}