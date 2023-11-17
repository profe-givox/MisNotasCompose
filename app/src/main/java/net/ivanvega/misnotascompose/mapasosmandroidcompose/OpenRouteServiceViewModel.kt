package net.ivanvega.misnotascompose.mapasosmandroidcompose

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import net.ivanvega.misnotascompose.data.network.OpenRouteServiceApi
import net.ivanvega.misnotascompose.model.GeoJSONDirection
import org.osmdroid.util.GeoPoint
import kotlin.coroutines.coroutineContext

data class DirectUIstate(var resp: GeoJSONDirection? = null)
class OpenRouteServiceViewModel : ViewModel() {

    var directUiState : MutableState<DirectUIstate> = mutableStateOf(DirectUIstate())

    init{
        directions_get("driving-car",
            GeoPoint(20.139261336104898, -101.15026781862757),
            GeoPoint(20.142110828753893, -101.1787275290486),
        )
    }

    fun directions_get( profile: String,  start: GeoPoint,  end: GeoPoint){

        viewModelScope.launch {

//            val route = OpenRouteServiceApi.retrofitService.directions_get(
//                profile = "driving-car",
//                start = "${start.longitude},${start.latitude}",
//                end = "${end.longitude},${end.latitude}"
//            )
             OpenRouteServiceApi.retrofitService.directions_get(
            )
            //directUiState.value = DirectUIstate(route)
            Log.d("GIVO ","")

        }
    }

}