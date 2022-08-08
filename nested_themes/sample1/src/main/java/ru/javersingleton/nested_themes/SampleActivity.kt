package ru.javersingleton.nested_themes

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Row
import ru.javersingleton.nested_themes.themes.common.button.Button
import ru.javersingleton.nested_themes.themes.common.content.LocalContentStyles
import ru.javersingleton.nested_themes.themes.common.promo_block.PromoBlock
import ru.javersingleton.nested_themes.themes.redesign.RedesignTheme

class SampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RedesignTheme {
                Row {
                    PromoBlock { contentStyles ->
                        Button(
                            title = "In PromoBlock",
                            style = contentStyles.buttonPrimaryStyle(),
                            onClick = { }
                        )
                    }
                    Button(
                        title = "Out PromoBlock",
                        style = LocalContentStyles.current().buttonPrimaryStyle(),
                        onClick = { }
                    )
                }
            }
        }
    }
}