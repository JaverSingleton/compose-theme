package ru.javersingleton.nested_themes.themes.redesign

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import ru.javersingleton.nested_themes.themes.common.StyleProvider
import ru.javersingleton.nested_themes.themes.common.component.content.ContentStyle
import ru.javersingleton.nested_themes.themes.common.component.content.createContentStyle
import ru.javersingleton.nested_themes.themes.common.component.promo_block.PromoBlockStyle
import ru.javersingleton.nested_themes.themes.common.component.promo_block.createPromoBlock
import ru.javersingleton.nested_themes.themes.redesign.button.RedesignButtonStyle
import ru.javersingleton.nested_themes.themes.redesign.button.createRedesignButtonPrimaryLarge

data class RedesignStyles(
    val contentStyle: StyleProvider<ContentStyle> = createContentStyle(),
    val buttonPrimaryLarge: StyleProvider<RedesignButtonStyle> = createRedesignButtonPrimaryLarge(),
    val promoBlock: StyleProvider<PromoBlockStyle> = createPromoBlock(),
)

internal val LocalRedesignStyles: ProvidableCompositionLocal<RedesignStyles> =
    staticCompositionLocalOf { RedesignStyles() }