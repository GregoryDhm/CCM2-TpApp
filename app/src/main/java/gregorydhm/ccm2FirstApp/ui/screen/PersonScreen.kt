package gregorydhm.ccm2FirstApp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import gregorydhm.ccm2FirstApp.ui.model.FakePersonUi
import gregorydhm.ccm2FirstApp.ui.viewmodel.FakePersonViewModel

@Composable
fun PersonScreen() {
    val viewModel: FakePersonViewModel = viewModel()
    val list = viewModel.quote.collectAsState(emptyList()).value

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(list) { item ->
                    PersonCard(item)
                }
            }

            // Section des boutons en bas de l'écran
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { viewModel.insertNewFakePerson() }
                ) {
                    Text("Add")
                }
                Button(
                    onClick = { viewModel.deleteAllPerson() }
                ) {
                    Text("Delete")
                }
            }
        }
    }
}

@Composable
fun PersonCard(item: FakePersonUi) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), // Espacement entre les cartes
        elevation = CardDefaults.cardElevation(4.dp) // Ajoute une ombre
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp) // Padding interne de la carte
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally, // Centre le texte horizontalement
            verticalArrangement = Arrangement.spacedBy(8.dp) // Espace entre les éléments dans la colonne
        ) {
            Text(
                text = "Gender: ${item.gender}",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Name: ${item.lastName.uppercase()} ${item.firstName}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
