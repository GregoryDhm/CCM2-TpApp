@file:Suppress("UNREACHABLE_CODE")

package gregorydhm.ccm2FirstApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import gregorydhm.ccm2FirstApp.ui.navigation.HomeNavHost
import gregorydhm.ccm2FirstApp.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        Box(
                            modifier = Modifier
                                //.fillMaxSize()
                                .padding(innerPadding)
                        ) {
                            Column {
                                HomeNavHost(
                                    navController = navController
                                ) // Will be red for the beginning
                                Greeting(
                                    name = "Android",
                                    modifier = Modifier.padding(innerPadding)
                                )
                            }
                        }
                        RImage()
                    }
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun GreetingPreview() {
        MyApplicationTheme {
            Column {
                Greeting("Android")
            }
        }
    }

    @Composable
    private fun RImage() {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            val painter = rememberAsyncImagePainter(
                ImageRequest
                    .Builder(LocalContext.current)
                    .data(data = "https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExamhvZDUxYzFrZXJ6bnJqdDU0amVzbzZoZjMwMXh3ZTVuazB2Z2YzZCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/MaCAVIpjoelYQ/giphy.gif")
                    .build()
            )
            Image(
                modifier = Modifier.size(128.dp),
                painter = painter,
                contentDescription = null,
            )
        }
    }
}

