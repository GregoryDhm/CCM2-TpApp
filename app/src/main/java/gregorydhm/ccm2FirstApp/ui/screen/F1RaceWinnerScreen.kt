package gregorydhm.ccm2FirstApp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import gregorydhm.ccm2FirstApp.ui.model.F1RaceWinnerUi
import gregorydhm.ccm2FirstApp.ui.viewmodel.F1RaceWinnerModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun F1DriversScreen(
    navController: NavController,
    viewModel: F1RaceWinnerModel = viewModel()
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
        },
        bottomBar = {
            Row {
                Button(
                    modifier = Modifier.weight(1f),
                    content = {
                        Text("Add")
                    },
                    onClick = {
                        viewModel.insertF1DriverWinRace()
                    }
                )
                Button(
                    modifier = Modifier.weight(1f),
                    content = {
                        Text("Delete")
                    },
                    onClick = {
                        viewModel.deleteAllF1RaceWinner()
                    }
                )
            }
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
    val viewModel: F1RaceWinnerModel = viewModel()
    //val listOfResult = viewModel.f1DriverList.collectAsState().value
    val listOfResult = viewModel.f1RaceWinnerList.collectAsState(emptyList()).value
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        /*val listOfResult: MutableList<F1DriverUi> = mutableListOf()
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
            }*/
        LazyColumn(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(listOfResult) { item ->
                when (item) {
                    is F1RaceWinnerUi.Header ->
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

                    is F1RaceWinnerUi.Item -> OutlinedCard(
                        modifier = Modifier.fillParentMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillParentMaxWidth()
                                .padding(8.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "Circuit: ${item.Circuit}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Number de tours: ${item.laps}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            if (item.domicile){
                                Text(
                                    text = "Victoire à domicile",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color(0xFF388E3C)
                                )
                            }
                        }
                    }
                    is F1RaceWinnerUi.Footer ->
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
                                    text = "Total de victoires : ${item.footer}",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    is F1RaceWinnerUi.FooterTotal -> OutlinedCard(
                        modifier = Modifier.fillParentMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillParentMaxWidth()
                                .padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Total de Courses : ${item.footerTotal}",
                                style = MaterialTheme.typography.displaySmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }

    }
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
            modifier = Modifier.size(200.dp),
            painter = painter,
            contentDescription = null,
        )
}