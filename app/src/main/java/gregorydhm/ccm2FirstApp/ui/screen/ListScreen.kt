package gregorydhm.ccm2FirstApp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import gregorydhm.ccm2FirstApp.ui.model.ItemUi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("List Screen") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column {
            Text(
                modifier = Modifier.padding(padding),
                text = "Second screen",
            )
            MyScreen()
        }
    }
}

@Composable
private fun MyScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        val listOfResult: MutableList<ItemUi> = mutableListOf()


        populateMyList() // listOf(MyAndroidObject)
            .groupBy { myAndroidObject ->
                myAndroidObject.versionName
            } // map <String, List<MyAndroidObject>> ex : <Ice Cream Sandwich, listOf("4.0.0","4.0.1","4.0.2","4.0.3")>
            .forEach { // versionName
                listOfResult.add(
                    ItemUi.Header(
                        title = it.key, // key = versionName
                    )
                )
                listOfResult.addAll(
                    it.value // List of android version number for the given name
                )
            }
        LazyColumn(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(listOfResult) { item ->
                when (item) {
                    is ItemUi.Header ->
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


                    is ItemUi.MyAndroidObject -> Text(
                        text = "Number ${item.versionNumber}",
                        style = MaterialTheme.typography.titleSmall,
                    )
                }
            }
        }

    }
}



private fun populateMyList(): List<ItemUi.MyAndroidObject> {
    return listOf<ItemUi.MyAndroidObject>(
        ItemUi.MyAndroidObject(versionName = "HoneyComb", versionNumber = "3.0"),
        ItemUi.MyAndroidObject(versionName = "Ice Cream Sandwich", versionNumber = "4.0"),
        ItemUi.MyAndroidObject(versionName = "Ice Cream Sandwich", versionNumber = "4.0.1"),
        ItemUi.MyAndroidObject(versionName = "Ice Cream Sandwich", versionNumber = "4.0.2"),
        ItemUi.MyAndroidObject(versionName = "Ice Cream Sandwich", versionNumber = "4.0.3"),
        ItemUi.MyAndroidObject(versionName = "Jelly Bean", versionNumber = "4.1"),
        ItemUi.MyAndroidObject(versionName = "Jelly Bean", versionNumber = "4.2"),
        ItemUi.MyAndroidObject(versionName = "Jelly Bean", versionNumber = "4.3"),
        ItemUi.MyAndroidObject(versionName = "Kitkat", versionNumber = "4.4"),
        ItemUi.MyAndroidObject(versionName = "Lollipop", versionNumber = "5.0"),
        ItemUi.MyAndroidObject(versionName = "Lollipop", versionNumber = "5.1"),
        ItemUi.MyAndroidObject(versionName = "Marshmallow", versionNumber = "6.0"),
        ItemUi.MyAndroidObject(versionName = "Nougat", versionNumber = "7.0"),
        ItemUi.MyAndroidObject(versionName = "Oreo", versionNumber = "8.0"),
        ItemUi.MyAndroidObject(versionName = "Oreo", versionNumber = "8.1"),
    )
}
