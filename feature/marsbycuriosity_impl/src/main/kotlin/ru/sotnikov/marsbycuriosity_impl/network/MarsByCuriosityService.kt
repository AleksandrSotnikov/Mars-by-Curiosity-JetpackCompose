package ru.sotnikov.marsbycuriosity_impl.network

import retrofit2.http.GET
import retrofit2.http.Query
import ru.sotnikov.marsbycuriosity_impl.model.Photos

interface MarsByCuriosityService {
    @GET("photos")
    suspend fun getCamerasList(
        @Query("api_key") apiKey : String,
        @Query("earth_date") date : String
    ) : Photos
}
