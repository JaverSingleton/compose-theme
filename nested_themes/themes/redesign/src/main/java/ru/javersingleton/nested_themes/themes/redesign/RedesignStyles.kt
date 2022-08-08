package ru.javersingleton.nested_themes.themes.redesign

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import ru.javersingleton.nested_themes.themes.common.StyleProvider
import ru.javersingleton.nested_themes.themes.common.component.button.ButtonStyle
import ru.javersingleton.nested_themes.themes.common.component.button.createButtonPrimaryLarge
import ru.javersingleton.nested_themes.themes.common.component.content.ContentStyle
import ru.javersingleton.nested_themes.themes.common.component.content.createContentStyle
import ru.javersingleton.nested_themes.themes.common.component.promo_block.PromoBlockStyle
import ru.javersingleton.nested_themes.themes.common.component.promo_block.createPromoBlock

data class RedesignStyles(
    val contentStyle: StyleProvider<ContentStyle> = createContentStyle(),
    val buttonPrimaryLarge: StyleProvider<ButtonStyle> = createButtonPrimaryLarge(),
    val promoBlock: StyleProvider<PromoBlockStyle> = createPromoBlock(),
)

internal val LocalRedesignStyles: ProvidableCompositionLocal<RedesignStyles> =
    staticCompositionLocalOf { RedesignStyles() }