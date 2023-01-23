package ru.sotnikov.marsbycuriosity_impl.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Photo(
    @SerialName("camera")
    val camera: Camera,
    @SerialName("earth_date")
    val earthDate: String,
    @SerialName("id")
    val id: Int,
    @SerialName("img_src")
    val imgSrc: String,
    @SerialName("rover")
    val rover: Rover,
    @SerialName("sol")
    val sol: Int
)
fun Photo.toDomain(): ru.sotnikov.marsbycuriosity_api.model.Photo {
    return ru.sotnikov.marsbycuriosity_api.model.Photo(camera = camera.toDomain(), earthDate = earthDate, id = id, imgSrc = imgSrc, rover = rover.toDomain(),sol = sol)
}

