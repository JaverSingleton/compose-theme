package ru.javersingleton.nested_themes.themes.common.promo_block

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.content.ContentStyles
import ru.javersingleton.nested_themes.themes.common.content.contentStyles

data class PromoBlockStyle(
    val contentStyles: ContentStyles,
)

@Composable
fun Theme.promoBlockDefault(): PromoBlockStyle = PromoBlockStyle(
    contentStyles = contentStyles
)
val LocalPromoBlockDefault: ProvidableCompositionLocal<PromoBlockStyle> =
    staticCompositionLocalOf { throw IllegalStateException() }

val Theme.promoBlockDefault: PromoBlockStyle
    @Composable
    @ReadOnlyComposable
    get() = LocalPromoBlockDefault.current

