package ru.sotnikov.marsbycuriosity_impl.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Camera(
    @SerialName("full_name")
    val fullName: String,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("rover_id")
    val roverId: Int
)

fun Camera.toDomain():ru.sotnikov.marsbycuriosity_api.model.Camera{
    return ru.sotnikov.marsbycuriosity_api.model.Camera(fullName = fullName, id = id, name = name, roverId = roverId)
}
