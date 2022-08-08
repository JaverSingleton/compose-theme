package ru.javersingleton.nested_themes.themes.common

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import ru.javersingleton.nested_themes.themes.common.component.button.ButtonStyle
import ru.javersingleton.nested_themes.themes.common.component.button.createButtonPrimaryLarge
import ru.javersingleton.nested_themes.themes.common.component.content.ContentStyles
import ru.javersingleton.nested_themes.themes.common.component.content.createContentStyles
import ru.javersingleton.nested_themes.themes.common.component.promo_block.PromoBlockStyle
import ru.javersingleton.nested_themes.themes.common.component.promo_block.createPromoBlock

data class Styles(
    val contentStyles: StyleProvider<ContentStyles> = createContentStyles(),
    val buttonPrimaryLarge: StyleProvider<ButtonStyle> = createButtonPrimaryLarge(),
    val promoBlock: StyleProvider<PromoBlockStyle> = createPromoBlock(),
)

internal val LocalStyles: ProvidableCompositionLocal<Styles> =
    staticCompositionLocalOf { Styles() }