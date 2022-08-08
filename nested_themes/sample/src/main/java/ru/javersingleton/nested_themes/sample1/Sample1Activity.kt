package ru.javersingleton.nested_themes.sample1

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.common.component.button.Button
import ru.javersingleton.nested_themes.themes.default.DefaultTheme

class Sample1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                val defaultTheme = @Composable { content: @Composable () -> Unit ->
                    DefaultTheme {
                        content()
                    }
                }
                val sample1Theme = @Composable { content: @Composable () -> Unit ->
                    Sample1Theme {
                        content()
                    }
                }
                val currentTheme = remember { mutableStateOf(defaultTheme) }
                currentTheme.value {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { currentTheme.value = sample1Theme },
                        title = "Sample1Theme",
                        style = Theme.styles.buttonPrimaryLarge()
                    )
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { currentTheme.value = defaultTheme },
                        title = "DefaultTheme",
                        style = Theme.styles.buttonPrimaryLarge()
                    )
                }
            }
        }
    }
}

