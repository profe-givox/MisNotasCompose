package net.ivanvega.misnotascompose.model

import kotlinx.serialization.Serializable
@Serializable
data class Geometry (val coordinates : List<DoubleArray>)
@Serializable
data class Feature(val geometry : Geometry)
@Serializable
data class GeoJSONDirection(
    val type: String,
    val features: List<Feature>
)




