package ru.javersingleton.nested_themes.themes.common.promo_block

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import ru.javersingleton.nested_themes.themes.common.StyleProvider
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.button.buttonPrimaryLarge
import ru.javersingleton.nested_themes.themes.common.content.ContentStyles
import ru.javersingleton.nested_themes.themes.common.content.contentStyles
import ru.javersingleton.nested_themes.themes.common.lazyStyle

data class PromoBlockStyle(
    val contentStyles: StyleProvider<ContentStyles>,
)

val LocalPromoBlock: ProvidableCompositionLocal<StyleProvider<PromoBlockStyle>> =
    staticCompositionLocalOf {
        lazyStyle {
            PromoBlockStyle(
                contentStyles = lazyStyle(Theme.contentStyles) {
                    copy(
                        buttonPrimaryStyle = lazyStyle(Theme.buttonPrimaryLarge) {
                            copy(
                                backgroundColor = Theme.colors.warmGray4
                            )
                        }
                    )
                }
            )
        }
    }

val Theme.promoBlock: StyleProvider<PromoBlockStyle>
    @Composable
    @ReadOnlyComposable
    get() = LocalPromoBlock.current




