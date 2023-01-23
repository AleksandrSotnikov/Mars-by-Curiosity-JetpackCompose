package ru.sotnikov.marsbycuriosity_impl.repository

import ru.sotnikov.marsbycuriosity_api.model.Photo
import ru.sotnikov.marsbycuriosity_api.repository.PhotosRepository
import ru.sotnikov.marsbycuriosity_api.model.Photos
import ru.sotnikov.marsbycuriosity_impl.model.toDomain
import ru.sotnikov.marsbycuriosity_impl.network.MarsByCuriosityService

class PhotosRepositoryImpl(private val apiService: MarsByCuriosityService) : PhotosRepository {
    override suspend fun getPhotosList(apikey: String, date: String): List<Photo> {
        return  apiService.getCamerasList(apikey,date).toDomain().photos;
    }
}
