package net.ivanvega.misnotascompose.mapasosmandroidcompose

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

    fun directions_get( profile: String,  start: GeoPoint,  end: GeoPoint){
        val start =
        viewModelScope.launch {

            val route = OpenRouteServiceApi.retrofitService.directions_get(
                profile = "",
                start = "${start.longitude},${start.latitude}",
                end = "${end.longitude},${end.latitude}"
            )
            directUiState.value = DirectUIstate(route)

        }
    }

}