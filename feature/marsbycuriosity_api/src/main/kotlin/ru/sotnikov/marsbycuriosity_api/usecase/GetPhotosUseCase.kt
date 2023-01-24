package ru.sotnikov.marsbycuriosity_api.usecase

import ru.sotnikov.marsbycuriosity_api.model.Photo
import ru.sotnikov.marsbycuriosity_api.repository.PhotosRepository

class GetPhotosUseCase(private val photosRepository: PhotosRepository) {
    suspend operator fun invoke(apiKey: String, date: String, camera: String): List<Photo> {
        return photosRepository.getPhotosCameraList(apikey = apiKey, date = date, camera = camera)
    }
}
