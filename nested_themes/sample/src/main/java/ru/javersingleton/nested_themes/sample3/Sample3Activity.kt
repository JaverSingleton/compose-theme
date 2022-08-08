package ru.javersingleton.nested_themes.sample3

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.ui.unit.dp
import ru.javersingleton.nested_themes.themes.common.Theme
import ru.javersingleton.nested_themes.themes.redesign.RedesignTheme

class Sample3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                RedesignTheme {
                    Text(
                        text = "DefaultTheme",
                        style = Theme.typography.h5,
                        color = Theme.colors.constantWhite,
                    )
                    Sample3Button(
                        onClick = { /*TODO*/ },
                        title = "CustomButton",
                        style = Theme.styles.buttonPrimaryLarge()
                    )
                }
                Sample3Theme {
                    Text(
                        text = "Sample3Theme",
                        style = Theme.typography.h5,
                        color = Theme.colors.constantWhite,
                    )
                    Sample3Button(
                        onClick = { /*TODO*/ },
                        title = "CustomButton",
                        style = Theme.styles.buttonPrimaryLarge()
                    )
                }
            }
        }
    }
}