package ru.javersingleton.nested_themes.themes.common.component.promo_block

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.component.content.ContentStyles
import ru.javersingleton.nested_themes.themes.common.component.content.LocalContentStyles

@Composable
fun PromoBlock(
    modifier: Modifier = Modifier,
    style: PromoBlockStyle = Theme.styles.promoBlock(),
    content: @Composable (contentStyles: ContentStyles) -> Unit
) {
    Surface(
        modifier = modifier
    ) {
        CompositionLocalProvider(
            LocalContentStyles provides remember { style.contentStyles },
        ) {
            content(LocalContentStyles.current())
        }
    }
}



