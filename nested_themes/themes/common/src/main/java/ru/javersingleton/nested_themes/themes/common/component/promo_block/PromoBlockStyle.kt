package ru.javersingleton.nested_themes.themes.common.component.promo_block

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import ru.javersingleton.nested_themes.themes.common.StyleProvider
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.component.content.ContentStyle
import ru.javersingleton.nested_themes.themes.common.component.content.LocalContentStyle
import ru.javersingleton.nested_themes.themes.common.lazyStyle

interface PromoBlockStyle {
    val contentStyle: StyleProvider<ContentStyle>
    val padding: PaddingValues
    val shape: Shape
    val color: Color
    val contentColor: Color

    fun copy(
        contentStyle: StyleProvider<ContentStyle> = this.contentStyle,
        padding: PaddingValues = this.padding,
        shape: Shape = this.shape,
        color: Color = this.color,
        contentColor: Color = this.contentColor,
    ): PromoBlockStyle

}

class DefaultPromoBlockStyle(
    override val contentStyle: StyleProvider<ContentStyle>,
    override val padding: PaddingValues,
    override val shape: Shape,
    override val color: Color,
    override val contentColor: Color,
) : PromoBlockStyle {

    override fun copy(
        contentStyle: StyleProvider<ContentStyle>,
        padding: PaddingValues,
        shape: Shape,
        color: Color,
        contentColor: Color
    ): PromoBlockStyle = DefaultPromoBlockStyle(
        contentStyle = contentStyle,
        padding = padding,
        shape = shape,
        color = color,
        contentColor = contentColor,
    )

}

fun createPromoBlock(): StyleProvider<PromoBlockStyle> = lazyStyle {
    DefaultPromoBlockStyle(
        padding = PaddingValues(
            top = 10.dp,
            start = 16.dp,
            end = 16.dp,
            bottom = 16.dp
        ),
        shape = RoundedCornerShape(5.dp),
        color = Theme.colors.green50,
        contentColor = Theme.colors.constantBlack,
        contentStyle = lazyStyle(LocalContentStyle.current) {
            copy(
                buttonPrimaryStyle = lazyStyle(buttonPrimaryStyle) {
                    copy(
                        backgroundColor = Theme.colors.constantWhite,
                        contentColor = Theme.colors.constantBlack,
                    )
                },
                buttonSecondaryStyle = lazyStyle(buttonPrimaryStyle) {
                    copy(
                        backgroundColor = Theme.colors.constantWhite,
                        contentColor = Theme.colors.constantBlack,
                    )
                },
                titleStyle = Theme.typography.h5,
                descriptionStyle = Theme.typography.m1
            )
        }
    )
}




