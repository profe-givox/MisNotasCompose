package net.ivanvega.misnotascompose

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import net.ivanvega.misnotascompose.location.CurrentLocationScreen
import net.ivanvega.misnotascompose.location.LocationPermissionScreen
import net.ivanvega.misnotascompose.location.LocationUpdatesScreen
import net.ivanvega.misnotascompose.mapasgoogle.MapaComposeGoogle
import net.ivanvega.misnotascompose.mapasosmandroidcompose.OSMComposeMapa
import net.ivanvega.misnotascompose.mapasosmandroidcompose.OpenRouteServiceViewModel

import net.ivanvega.misnotascompose.ui.theme.MisNotasComposeTheme

class ActivityLocalizacion : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MisNotasComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

                      //1   //LocationPermissionScreen()
                     //2   //CurrentLocationScreen()
                     //3   //LocationUpdatesScreen()

                    }
                    val vm :  OpenRouteServiceViewModel =  viewModel()
                    OSMComposeMapa(viewModel =vm)
                    //Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MisNotasComposeTheme {
        Greeting2("Android")
    }
}