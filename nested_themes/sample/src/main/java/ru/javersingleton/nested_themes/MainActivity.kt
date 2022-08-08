package ru.javersingleton.nested_themes

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.javersingleton.nested_themes.sample1.Sample1Activity
import ru.javersingleton.nested_themes.sample2.Sample2Activity
import ru.javersingleton.nested_themes.sample3.Sample3Activity
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.component.button.Button
import ru.javersingleton.nested_themes.themes.default.DefaultTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultTheme {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            startActivity(Intent(this@MainActivity, Sample1Activity::class.java))
                        },
                        title = "Переключение тем",
                        style = Theme.styles.buttonPrimaryLarge()
                    )
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            startActivity(Intent(this@MainActivity, Sample2Activity::class.java))
                        },
                        title = "Контекстозависимые стили",
                        style = Theme.styles.buttonPrimaryLarge()
                    )
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            startActivity(Intent(this@MainActivity, Sample3Activity::class.java))
                        },
                        title = "Модифицированный компонент",
                        style = Theme.styles.buttonPrimaryLarge()
                    )
                }
            }
        }
    }
}