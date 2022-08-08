package ru.javersingleton.nested_themes.themes.common

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import ru.javersingleton.nested_themes.themes.common.button.ButtonStyle
import ru.javersingleton.nested_themes.themes.common.button.createButtonPrimaryLarge
import ru.javersingleton.nested_themes.themes.common.content.ContentStyles
import ru.javersingleton.nested_themes.themes.common.content.createContentStyles
import ru.javersingleton.nested_themes.themes.common.promo_block.PromoBlockStyle
import ru.javersingleton.nested_themes.themes.common.promo_block.createPromoBlock

data class Styles(
    val contentStyles: StyleProvider<ContentStyles> = createContentStyles(),
    override val buttonPrimaryLarge: StyleProvider<ButtonStyle> = createButtonPrimaryLarge(),
    override val promoBlock: StyleProvider<PromoBlockStyle> = createPromoBlock(),
) : ButtonStyles, PromoBlockStyles

interface ButtonStyles {
    val buttonPrimaryLarge: StyleProvider<ButtonStyle>
}

interface PromoBlockStyles {
    val promoBlock: StyleProvider<PromoBlockStyle>
}

internal val LocalStyles: ProvidableCompositionLocal<Styles> =
    staticCompositionLocalOf { Styles() }