package akw.app1

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonsView(
    isGameOver: Boolean,
    dispatch: BlackjackDispatch
) {
    Button(enabled = isGameOver, modifier = Modifier.padding(all = 10.dp), onClick = {
        dispatch(BlackjackAction.Deal)
    }) {
        Text(text = "Deal")
    }
    Button(enabled = !isGameOver, modifier = Modifier.padding(all = 10.dp), onClick = {
        dispatch(BlackjackAction.Hit)
    }) {
        Text(text = "Hit")
    }
    Button(enabled = !isGameOver, modifier = Modifier.padding(all = 10.dp), onClick = {
        dispatch(BlackjackAction.Stay)
    }) {
        Text(text = "Stay")
    }
}