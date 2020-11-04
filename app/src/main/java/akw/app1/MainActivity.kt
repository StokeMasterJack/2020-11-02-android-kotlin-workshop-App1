package akw.app1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

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
    MaterialTheme() {
        Surface(color = Color.LightGray, modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.padding(all = 10.dp).fillMaxWidth()) {
                Text(text = "Blackjack")

                Row(horizontalArrangement = Arrangement.Center,modifier = Modifier.padding(all = 10.dp).fillMaxWidth()) {
                    Button(modifier = Modifier.padding(all = 10.dp), onClick = {}) {
                        Text(text = "Deal")
                    }
                    Button(modifier = Modifier.padding(all = 10.dp),onClick = {}) {
                        Text(text = "Hit")
                    }
                    Button(modifier = Modifier.padding(all = 10.dp),onClick = {}) {
                        Text(text = "Stay")
                    }
                }
                Row(modifier = Modifier.padding(bottom = 10.dp)) {
                    HandView("Player")
                    HandView("Dealer")
                }

                Surface(color = Color.Yellow, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Game Message",textAlign = TextAlign.Center)
                }

            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    Blackjack()
}