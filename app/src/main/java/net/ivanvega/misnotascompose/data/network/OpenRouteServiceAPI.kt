package net.ivanvega.misnotascompose.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import net.ivanvega.misnotascompose.model.GeoJSONDirection
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL =
    "https://api.openrouteservice.org"

private const val API_KEY =
    "5b3ce3597851110001cf624819e6024a736b4766afe215764a8bdba1"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface IOpenRouteServiceAPI {
    @GET("/v2/directions/{profile}")
    suspend fun directions_get( @Path("profile") profile: String,
                        @Query("api_key ") apikey : String = API_KEY,
                        @Query("start") start : String ,
                        @Query("end") end : String ): GeoJSONDirection

    @GET("/v2/directions/driving-car?api_key=5b3ce3597851110001cf624819e6024a736b4766afe215764a8bdba1&start=8.681495,49.41461&end=8.687872,49.420318")
    suspend  fun directions_get( ): GeoJSONDirection
}

object OpenRouteServiceApi {
    val retrofitService : IOpenRouteServiceAPI by lazy {
        retrofit.create(IOpenRouteServiceAPI::class.java)
    }
}

