package akw.app1

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun HandView(name: String) {
    Column {
        Text(name)
        Text("Card List")
        Text("Points")
    }
}