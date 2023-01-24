package ru.sotnikov.marsbycuriosity_impl.repository

import ru.sotnikov.marsbycuriosity_api.model.Photo
import ru.sotnikov.marsbycuriosity_api.repository.PhotosRepository
import ru.sotnikov.marsbycuriosity_impl.model.toDomain
import ru.sotnikov.marsbycuriosity_impl.network.MarsByCuriosityService

class PhotosRepositoryImpl(private val apiService: MarsByCuriosityService) : PhotosRepository {
    override suspend fun getPhotosCameraList(apikey: String, date: String, camera: String): List<Photo> {
        return apiService.getPhotosList(apikey, date, camera).toDomain().photos;
    }
}
