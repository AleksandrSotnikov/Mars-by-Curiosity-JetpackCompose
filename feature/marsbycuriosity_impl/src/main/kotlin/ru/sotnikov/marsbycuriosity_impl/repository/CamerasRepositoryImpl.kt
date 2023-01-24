package ru.sotnikov.marsbycuriosity_impl.repository

import ru.sotnikov.marsbycuriosity_api.model.Photo
import ru.sotnikov.marsbycuriosity_api.repository.CamerasRepository
import ru.sotnikov.marsbycuriosity_impl.model.toDomain
import ru.sotnikov.marsbycuriosity_impl.network.MarsByCuriosityService

class CamerasRepositoryImpl(private val apiService: MarsByCuriosityService) : CamerasRepository {
    override suspend fun getPhotosList(apikey: String, date: String): List<Photo> {
        return apiService.getCamerasList(apikey, date).toDomain().photos;
    }


}
