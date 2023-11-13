package net.ivanvega.misnotascompose.mapasosmandroidcompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.utsman.osmandcompose.CameraState
import com.utsman.osmandcompose.DefaultMapProperties
import com.utsman.osmandcompose.OpenStreetMap
import com.utsman.osmandcompose.ZoomButtonVisibility
import com.utsman.osmandcompose.rememberCameraState
import com.utsman.osmandcompose.rememberOverlayManagerState
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.CopyrightOverlay

@Composable
fun OSMComposeMapa(
    modifier: Modifier = Modifier.fillMaxSize(),
){
    // define properties with remember with default value
    var mapProperties by remember {
        mutableStateOf(DefaultMapProperties)
    }

    // setup mapProperties in side effect
    SideEffect {
        mapProperties = mapProperties
            .copy(isTilesScaledToDpi = true)
            .copy(tileSources = TileSourceFactory.MAPNIK)
            .copy(isEnableRotationGesture = true)
            .copy(zoomButtonVisibility = ZoomButtonVisibility.NEVER)
    }


    // define camera state
    val cameraState = rememberCameraState {
        geoPoint = GeoPoint(20.1389,-101.15088)
        zoom = 18.0 // optional, default is 5.0
    }

    val overlayManagerState = rememberOverlayManagerState()

    val ctx = LocalContext.current
    //Agregar nodo Mapa
    OpenStreetMap(cameraState = cameraState  ,
        properties = mapProperties,
        overlayManagerState = overlayManagerState,
        onFirstLoadListener = {
            val copyright = CopyrightOverlay(ctx)
            overlayManagerState.overlayManager.add(copyright) // add another overlay in this listener
        },
        modifier = modifier)
    {

    }
}