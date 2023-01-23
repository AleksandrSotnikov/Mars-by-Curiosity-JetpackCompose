package ru.sotnikov.marsbycuriosity_api.repository

import ru.sotnikov.marsbycuriosity_api.model.Photo

interface PhotosRepository {
    suspend fun getPhotosList(apikey:String, date:String) : List<Photo>
}
