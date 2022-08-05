package ru.javersingleton.nested_themes.themes.common.promo_block

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.content.LocalContentStyles

@Composable
fun PromoBlock(
    modifier: Modifier = Modifier,
    style: PromoBlockStyle = Theme.promoBlock(),
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier
    ) {
        CompositionLocalProvider(
            LocalContentStyles provides remember { style.contentStyles },
        ) {
            content()
        }
    }
}



