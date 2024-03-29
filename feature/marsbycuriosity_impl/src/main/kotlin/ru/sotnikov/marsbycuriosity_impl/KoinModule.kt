package ru.sotnikov.marsbycuriosity_impl

import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.dsl.module
import ru.sotnikov.marsbycuriosity_api.repository.CamerasRepository
import ru.sotnikov.marsbycuriosity_api.repository.PhotosRepository
import ru.sotnikov.marsbycuriosity_api.usecase.GetCameraNameUseCase
import ru.sotnikov.marsbycuriosity_api.usecase.GetPhotosUseCase
import ru.sotnikov.marsbycuriosity_impl.network.getMarsByCuriosityService
import ru.sotnikov.marsbycuriosity_impl.repository.CamerasRepositoryImpl
import ru.sotnikov.marsbycuriosity_impl.repository.PhotosRepositoryImpl


@ExperimentalSerializationApi
val marsByCuriosityModule = module{
    single { getMarsByCuriosityService() }

    single { GetCameraNameUseCase(get()) }
    single { GetPhotosUseCase(get()) }

    single<CamerasRepository> {
        CamerasRepositoryImpl(get())
    }
    single<PhotosRepository> {
        PhotosRepositoryImpl(get())
    }
}
