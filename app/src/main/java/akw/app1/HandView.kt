package akw.app1

import akw.app1.blackjack.Hand
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HandView(h: Hand) {
    Surface(color = Color.Cyan) {


        Column(modifier = Modifier.padding(all = 10.dp)) {
            Text(h.name, fontWeight = FontWeight.Bold)
            Column {
                h.cards.forEach {
                    Text(it.name)
                }
            }

            Text("${h.points} Points", fontWeight = FontWeight.Bold)
        }
    }
}