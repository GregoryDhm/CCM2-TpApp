package gregorydhm.ccm2FirstApp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import gregorydhm.ccm2FirstApp.ui.model.F1DriverUi
import gregorydhm.ccm2FirstApp.ui.model.ItemUi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun F1DriversScreen(
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("F1 drivers victoires 2024") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f)
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                F1Image()
            }
            Box(
                modifier = Modifier.weight(3f)
            ) {
                F1DriversScreen()
            }
        }
    }
}

@Composable
private fun F1DriversScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        val listOfResult: MutableList<F1DriverUi> = mutableListOf()
        populateMyF1DriversList()
            .groupBy { it.name }
            .forEach { (name, drivers) ->
                val circuits = drivers.joinToString(", ") { it.victoire}

                // Ajoute un Header pour chaque groupe de pilotes
                listOfResult.add(F1DriverUi.Header(title = name))

                // Ajoute chaque pilote avec les circuits concaténés
                listOfResult.add(
                    F1DriverUi.f1DriverObject(
                        name = name,
                        victoire = circuits, // Concatène les circuits
                        nbVictoire = drivers.first().nbVictoire,
                        actif = drivers.first().actif
                    )
                )
            }
        LazyColumn(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(listOfResult) { item ->
                when (item) {
                    is F1DriverUi.Header ->
                        OutlinedCard(
                            modifier = Modifier.fillParentMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillParentMaxWidth()
                                    .padding(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = item.title,
                                    style = MaterialTheme.typography.displaySmall,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }

                    is F1DriverUi.f1DriverObject -> OutlinedCard(
                        modifier = Modifier.fillParentMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillParentMaxWidth()
                                .padding(8.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "Circuit: ${item.victoire}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Number of victories total: ${item.nbVictoire}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Active: ${if (item.actif) "Yes" else "No"}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }
        }

    }
}

private fun populateMyF1DriversList(): List<F1DriverUi.f1DriverObject> {
    return listOf<F1DriverUi.f1DriverObject>(
        F1DriverUi.f1DriverObject(name = "Charles Leclerc","Monaco", nbVictoire = 7, actif = true),
        F1DriverUi.f1DriverObject(name = "Charles Leclerc","Monza", nbVictoire = 7, actif = true),
        F1DriverUi.f1DriverObject(name = "Pierre Gasly","" ,nbVictoire = 1, actif = true),
        F1DriverUi.f1DriverObject(name = "Lando Norris","Miami", nbVictoire = 2, actif = true),
        F1DriverUi.f1DriverObject(name = "Alexander Albon", "", nbVictoire = 0, actif = true),
        F1DriverUi.f1DriverObject(name = "Logan Sargeant", "", nbVictoire = 0, actif = false),
    )
}
@Composable
private fun F1Image() {
        val painter = rememberAsyncImagePainter(
            ImageRequest
                .Builder(LocalContext.current)
                .data(data = "https://logos-marques.com/wp-content/uploads/2022/07/F1-logo.png")
                .build()
        )
        Image(
            modifier = Modifier.size(100.dp),
            painter = painter,
            contentDescription = null,
        )
}