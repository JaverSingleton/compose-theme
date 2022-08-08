package ru.javersingleton.nested_themes

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import ru.javersingleton.nested_themes.themes.common.StyleProvider
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.component.button.Button
import ru.javersingleton.nested_themes.themes.common.component.content.Content
import ru.javersingleton.nested_themes.themes.common.component.content.ContentStyle
import ru.javersingleton.nested_themes.themes.common.component.content.LocalContentStyle
import ru.javersingleton.nested_themes.themes.common.lazyStyle
import ru.javersingleton.nested_themes.themes.common.component.promo_block.PromoBlock
import ru.javersingleton.nested_themes.themes.common.component.promo_block.PromoBlockStyle
import ru.javersingleton.nested_themes.themes.redesign.RedesignTheme
import ru.javersingleton.nested_themes.themes.redesign.button.RedesignButton
import ru.javersingleton.nested_themes.themes.redesign.button.RedesignButtonStyle

class SampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                RedesignTheme {
                    PromoBlock(
                        title = "PromoBlock",
                        description = "Description text",
                        buttonsPanel = {
                            RedesignButton(
                                onClick = { /*TODO*/ },
                                title = "Primary Button",
                                style = it.buttonPrimaryStyle()
                            )
                            RedesignButton(
                                onClick = { /*TODO*/ },
                                title = "Secondary Button",
                                style = it.buttonSecondaryStyle()
                            )
                        },
                        style = myScreenPromoBlockStyle()
                    )
                    PromoBlock(
                        style = myScreenPromoBlockStyle(),
                        content = {
                            RedesignButton(
                                title = "Button",
                                style = it.buttonPrimaryStyle(),
                                onClick = { }
                            )
                        }
                    )
                }
                ScreenTheme {
                    RedesignButton(
                        title = "Button",
                        style = LocalContentStyle.current().buttonPrimaryStyle(),
                        onClick = { }
                    )
                }
            }
        }
    }
}

@Composable
fun myScreenPromoBlockStyle(): PromoBlockStyle =
    lazyStyle(Theme.styles.promoBlock) {
        copy(
            contentStyle = lazyStyle(contentStyle) {
                copy(
                    buttonPrimaryStyle = lazyStyle(buttonPrimaryStyle as StyleProvider<RedesignButtonStyle>) {
                        copy(
                            textPrefix = "PromoBlock $textPrefix"
                        )
                    }
                )
            }
        )
    }()
