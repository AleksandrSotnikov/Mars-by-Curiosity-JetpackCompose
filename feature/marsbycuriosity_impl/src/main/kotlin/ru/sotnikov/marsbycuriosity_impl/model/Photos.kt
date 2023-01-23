package ru.sotnikov.marsbycuriosity_impl.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Photos(
    @SerialName("photos")
    val photos: List<Photo>
)

fun Photos.toDomain(): ru.sotnikov.marsbycuriosity_api.model.Photos {
    return ru.sotnikov.marsbycuriosity_api.model.Photos(photos = photos.map { item -> item.toDomain() })
}
