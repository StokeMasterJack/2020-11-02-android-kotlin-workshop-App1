package akw.app1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Blackjack()
        }
    }
}

@Composable
fun Blackjack() {

    Column(modifier = Modifier.padding(all = 10.dp)) {
        Text(text = "Blackjack")

        Row {
            Button(onClick = {}) {
                Text(text = "Deal")
            }
            Button(onClick = {}) {
                Text(text = "Hit")
            }
            Button(onClick = {}) {
                Text(text = "Stay")
            }
        }

        Row {
            Text(text = "Player Hand")
            Text(text = "Dealer Hand")
        }

        Text(text = "Game Message")
    }
}