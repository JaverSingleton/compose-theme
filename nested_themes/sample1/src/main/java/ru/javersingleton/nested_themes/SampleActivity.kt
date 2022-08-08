package ru.javersingleton.nested_themes

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.component.content.LocalContentStyles
import ru.javersingleton.nested_themes.themes.common.lazyStyle
import ru.javersingleton.nested_themes.themes.common.component.promo_block.PromoBlock
import ru.javersingleton.nested_themes.themes.common.component.promo_block.PromoBlockStyle
import ru.javersingleton.nested_themes.themes.redesign.RedesignTheme
import ru.javersingleton.nested_themes.themes.redesign.button.RedesignButton

class SampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                RedesignTheme {
                    PromoBlock(style = myScreenPromoBlockStyle()) { contentStyles ->
                        val buttonStyle = contentStyles.buttonPrimaryStyle()
                        RedesignButton(
                            title = "Button",
                            style = buttonStyle,
                            onClick = { }
                        )
                    }

                }
                ScreenTheme {
                    RedesignButton(
                        title = "Button",
                        style = LocalContentStyles.current().buttonPrimaryStyle(),
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
            contentStyles = lazyStyle(contentStyles) {
                copy(
                    buttonPrimaryStyle = lazyStyle(RedesignTheme.styles.buttonPrimaryLarge) {
                        copy(
                            textPrefix = "PromoBlock $textPrefix"
                        )
                    }
                )
            }
        )
    }()
