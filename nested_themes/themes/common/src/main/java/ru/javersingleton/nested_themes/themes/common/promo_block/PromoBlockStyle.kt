package ru.javersingleton.nested_themes.themes.common.promo_block

import ru.javersingleton.nested_themes.themes.common.StyleProvider
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.content.ContentStyles
import ru.javersingleton.nested_themes.themes.common.content.LocalContentStyles
import ru.javersingleton.nested_themes.themes.common.lazyStyle

data class PromoBlockStyle(
    val contentStyles: StyleProvider<ContentStyles>,
)

fun createPromoBlock(): StyleProvider<PromoBlockStyle> = lazyStyle {
    PromoBlockStyle(
        contentStyles = lazyStyle(LocalContentStyles.current) {
            copy(
                buttonPrimaryStyle = lazyStyle(Theme.styles.buttonPrimaryLarge) {
                    copy(
                        backgroundColor = Theme.colors.warmGray4
                    )
                }
            )
        }
    )
}




