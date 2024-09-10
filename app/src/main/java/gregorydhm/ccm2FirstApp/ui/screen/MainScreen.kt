package gregorydhm.ccm2FirstApp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(
    onButtonClick: () -> Unit,
    onF1DriversClick: () -> Unit
) {
    Column(
        modifier = Modifier
            //.fillMaxSize()
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Grégory DEHAME")
        Row{
            Button(
                content = {
                    Text("go to list screen")
                },
                onClick = { onButtonClick() }
            )
            Button(
                content = {
                    Text("go to F1 drivers list")
                },
                onClick = { onF1DriversClick() }
            )
        }
    }
}
