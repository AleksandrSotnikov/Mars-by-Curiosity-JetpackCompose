package ru.sotnikov.marsbycuriosity_api.usecase

import ru.sotnikov.marsbycuriosity_api.model.Photo
import ru.sotnikov.marsbycuriosity_api.repository.CamerasRepository

class GetCameraNameUseCase(private val camerasRepository: CamerasRepository) {
    suspend operator fun invoke(apiKey: String, date: String): List<Photo> {
        return camerasRepository.getPhotosList(apikey = apiKey, date = date)
    }
}
