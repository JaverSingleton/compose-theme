package ru.javersingleton.nested_themes.themes.common.component.promo_block

import ru.javersingleton.nested_themes.themes.common.StyleProvider
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.component.content.ContentStyles
import ru.javersingleton.nested_themes.themes.common.component.content.LocalContentStyles
import ru.javersingleton.nested_themes.themes.common.lazyStyle

interface PromoBlockStyle {

    val contentStyles: StyleProvider<ContentStyles>

    fun copy(
        contentStyles: StyleProvider<ContentStyles> = this.contentStyles
    ): PromoBlockStyle

}

class DefaultPromoBlockStyle(
    override val contentStyles: StyleProvider<ContentStyles>
) : PromoBlockStyle {

    override fun copy(
        contentStyles: StyleProvider<ContentStyles>
    ): PromoBlockStyle = DefaultPromoBlockStyle(
        contentStyles = contentStyles
    )

}

fun createPromoBlock(): StyleProvider<PromoBlockStyle> = lazyStyle {
    DefaultPromoBlockStyle(
        contentStyles = lazyStyle(LocalContentStyles.current) {
            copy(
                buttonPrimaryStyle = lazyStyle(buttonPrimaryStyle) {
                    copy(
                        backgroundColor = Theme.colors.warmGray4
                    )
                }
            )
        }
    )
}




