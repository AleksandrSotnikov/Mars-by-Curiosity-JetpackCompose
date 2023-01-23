package ru.sotnikov.marsbycuriosity_api.usecase

import ru.sotnikov.marsbycuriosity_api.model.Photo
import ru.sotnikov.marsbycuriosity_api.repository.PhotosRepository

class GetCameraNameUseCase(private val photosRepository: PhotosRepository) {
    suspend operator fun invoke(apiKey:String,date:String) : List<Photo> {
        return photosRepository.getPhotosList(apikey = apiKey,date=date)
    }
}
