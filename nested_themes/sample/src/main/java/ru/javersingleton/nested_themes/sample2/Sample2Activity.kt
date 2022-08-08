package ru.javersingleton.nested_themes.sample2

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.javersingleton.nested_themes.themes.common.component.button.Button
import ru.javersingleton.nested_themes.themes.common.component.content.LocalContentStyle
import ru.javersingleton.nested_themes.themes.common.component.promo_block.PromoBlock
import ru.javersingleton.nested_themes.themes.redesign.RedesignTheme

class Sample2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RedesignTheme {
                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Sample2Button()
                    PromoBlock(
                        modifier = Modifier.fillMaxWidth(),
                        title = "PromoBlock",
                        buttonsPanel = {
                            Sample2Button()
                        }
                    )
                }
            }
        }
    }

    @Composable
    fun Sample2Button() {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { },
            title = "Button",
            style = LocalContentStyle.current().buttonPrimaryStyle()
        )
    }
}