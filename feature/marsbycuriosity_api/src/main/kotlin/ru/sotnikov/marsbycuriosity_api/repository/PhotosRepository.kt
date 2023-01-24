package ru.sotnikov.marsbycuriosity_api.repository

import ru.sotnikov.marsbycuriosity_api.model.Photo

interface PhotosRepository {
    suspend fun getPhotosCameraList(apikey: String, date: String, camera: String): List<Photo>
}
